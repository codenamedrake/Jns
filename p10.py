import socket
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
print ("Socket created")
PORT = 8000
HOST = ''
s.bind(('',PORT))
s.listen(5)
i=0
while True:
    try:
	dict={}
	i=i+1
        istr=str(i)
        c,addr = s.accept()
        c.settimeout(10)
        print('connection received from', addr)
	dict[str(addr)]=i;	
	for key in dict:
		if key==str(addr):
			dict[str(addr)]=i+1;
		else:
			dict[str(addr)]=1;	
        ad=str(addr)
	print(dict.items())
        msg = "<html><body><p>your IP & port are"+ad+" and connection number is "+istr+"</p></body></html>"#printing IP,connection number
        response_headers = {
        'Content-Type': 'text/html; encoding=utf8',
        'Content-Length': len(msg),
        'Connection': 'close',
        }

        response_headers_raw = ''.join('%s: %s\r\n' % (k, v) for k, v in response_headers.items())

        response_proto = 'HTTP/1.1'
        response_status = '200'
        response_status_text = 'OK'

        # sending 
        r = '%s %s %s\r\n' % (response_proto, response_status, response_status_text)
        c.send(r)
        c.send(response_headers_raw)
        c.send('\r\n') # to separate headers from body
        c.send(msg.encode(encoding="utf-8"))
        #c.send(msg2.encode(encoding="utf-8"))
    except socket.timeout() as e:
        print(e)
        c.close()

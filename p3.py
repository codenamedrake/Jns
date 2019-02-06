import socket

def test_socket_timeout():
     try:
    	s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    	print "Default socket timeout: %s" %s.gettimeout()
    	s.settimeout(100)
    	print "Current socket timeout: %s" %s.gettimeout()
     except socket.error, e:
    	if 'Connection refused' in e:
        	print '*** Connection refused ***'    
    
if __name__ == '__main__':
    test_socket_timeout()

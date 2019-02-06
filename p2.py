import socket


def get_remote_machine_info():
    remote_host = 'www.google.com'
    try:
        print 'IP address of %s: %s' % (remote_host,
                socket.gethostbyname(remote_host))
	ip=socket.gethostbyname(remote_host)
	print '.'.join([bin(int(x)+256)[3:] for x in ip.split('.')])
	print '-'.join([hex(int(x)+256)[3:] for x in ip.split('.')])
    except socket.error, err_msg:
        print '%s: %s' % (remote_host, err_msg)


if __name__ == '__main__':
    get_remote_machine_info()

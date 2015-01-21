import urllib2

if __name__ == '__main__':
	url = raw_input("Target url:")
	urllib2.Request(url)
	conn.request("GET", "")
	response = conn.getresponse()
	print '=============HEAD==============='
	for header in response.getheaders():
		print header
	print '=============BODY==============='
	print response.read()
	conn.close()
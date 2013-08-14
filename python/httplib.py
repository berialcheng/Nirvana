if __name__ == '__main__':
	url = raw_input("Target url:")
	import httplib
	conn = httplib.HTTPConnection(url)
	conn.request("GET", "")
	resp = conn.getresponse()
	print '=============HEAD==============='
	for header in resp.getheaders():
		print header
	print '=============BODY==============='
	print resp.read()
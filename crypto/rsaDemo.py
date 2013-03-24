import rsa

message = 'hello' 
with open('rsa.pub') as publickfile: 
	p = publickfile.read() 
	pubkey = rsa.PublicKey.load_pkcs1(p)
with open('rsa') as privatefile: 
	p = privatefile.read() 
	privkey = rsa.PrivateKey.load_pkcs1(p)

crypto = rsa.encrypt(message, pubkey)
print crypto
message = rsa.decrypt(crypto, privkey)
print message

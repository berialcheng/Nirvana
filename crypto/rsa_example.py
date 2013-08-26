'''
1. Choose two distinct prime numbers p and q.     
	p=3  q=5
2. Compute n = pq. 
	n=15
3. 	e=3  
  	(d*e)mod((p-1)*(q-1))=1
  	d=3
4.  (n, e)  (n, d)
    (15, 3)  (15, 3)
	c = m^e (mod n)
	m = c^d (mod n)
'''
def encrypt(m):
	return (m**3)%15
def decry(c):
	return (c**3)%15

if __name__ == '__main__':
	message = 7
	c = encrypt(message)
	print c
	print decry(c)
'''
MERGE-SORT(A, p ,r )
	if p<r
		then q <- (p+r)/2
			MERGE-SORT(A, p ,q )
			MERGE-SORT(A, q+1 ,r )
			MERGE(A, p, q, r)
'''
def merge(list, low , high):
	pass
'''
QUICKSORT(A, p , r)
	if p<r
		then q<- PARTITION(A, p, r)
			QUICKSORT(A, p, q-1)
			QUICKSORT(A, q+1 , r)
'''
def quick(list):
	pass

if __name__ == '__main__':
	list = [3, 2  , 6 , 1, 4 , 5 ]
	
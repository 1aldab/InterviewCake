# You have a list of integers, and for each index you want to find the 
# product of every integer except the integer at that index.
# Write a function get_products_of_all_ints_except_at_index() that takes 
# a list of integers and returns a list of the products.

def get_products_of_all_ints_except_at_index(arr):
	n = len(list)
	ltr = [None] * n
	rtl = [None] * n
	prod = [None] * n
	ltr[0] = 1
	rtl[n - 1] = 1
	for i in range(1, n):
		ltr[i] = arr[i - 1] * ltr[i - 1]
		rtl[n - i - 1] = arr[n - i] * rtl[n - i]
	for i in range(0, n):
		prod[i] = ltr[i] * rtl[i]
	return prod

def test(list):
	prod = get_products_of_all_ints_except_at_index(list)
	print "%s" % (str(list))
	print "%s" % (str(prod))

list = [1, 7, 3, 4]
test(list)
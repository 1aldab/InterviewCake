# Given an arrayOfInts, find the highestProduct you can get from three of the integers.
# The input arrayOfInts will always have at least three integers.
from heapq import *

def highestProductOf3(arr):
	smallest = []
	largest = []
	for element in arr:
		if len(largest) < 3:
			heappush(largest, element)
		else:
			heappushpop(largest, element)
		if len(smallest) < 2:
			heappush(smallest, -1 * element)
		else:
			heappushpop(smallest, -1 * element)
	cand1 = largest[0] * largest[1] * largest[2]
	cand2 = smallest[0] * smallest[1] * max(largest)
	return max(cand1, cand2)

def test(arr):
	print "Largest Product of Three in %s = %d" % (str(arr), highestProductOf3(arr))

arr = [1, 10, -5, 1, -100]
test(arr)
arr = [-10, -10, 1, 3, 2]
test(arr)
arr = [-10, -3, -2, -5, -6, -4, -8]
test(arr)
arr = [1, 4, 5, 2, 9, 10, 3]
test(arr)
# Write a function that, given:
# 1. an amount of money
# 2. an array of coin denominations
# computes the number of ways to make amount of money with coins of the available denominations.

cache = {}

def change(amount, denoms, i):
	if (amount == 0):
		return 1
	if (i == len(denoms)):
		return 0
	numWays = 0
	maxUse = amount / denoms[i]
	for j in range(0, maxUse + 1):
		remaining = amount - j * denoms[i]
		if (remaining, i + 1) in cache:
			numWays += cache[(remaining, i + 1)]
		else:	
			numWays += change(remaining, denoms, i + 1)
	cache[(amount, i)] = numWays
	return numWays

def test(amount, denoms):
	cache = {}
	n = change(amount, denoms, 0)
	print "Number of ways to change $%d using %s = %d" % (amount, str(denoms), n)

denoms = [1, 5, 10, 20]
test(0, denoms)
test(1, denoms)
test(2, denoms)
test(5, denoms)
test(6, denoms)
test(10, denoms)
test(11, denoms)
test(20, denoms)
test(1000, denoms)

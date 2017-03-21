def get_max_profit(stock_prices_yesterday):
	n = len(stock_prices_yesterday)
	min_price_sofar = stock_prices_yesterday[0]
	max_profit = 0
	buy = 0
	sell = 0
	for i in range(1, n):
		if min_price_sofar > stock_prices_yesterday[i]:
			min_price_sofar = stock_prices_yesterday[i]
			buy = i
		profit = stock_prices_yesterday[i] - min_price_sofar
		if profit > max_profit:
			max_profit = profit
			sell = i 
	return [buy, sell, max_profit]


def test(stock_prices_yesterday):
	result = get_max_profit(stock_prices_yesterday)
	print str(stock_prices_yesterday)
	print "buy at time %d, sell at time %d, profit = %d" %(result[0], result[1], result[2])

stock_prices_yesterday = [10, 7, 5, 8, 11, 9]
test(stock_prices_yesterday)
stock_prices_yesterday = [10, 9, 8, 7, 6, 5]
test(stock_prices_yesterday)
stock_prices_yesterday = [5, 6, 7, 8, 9, 10]
test(stock_prices_yesterday)
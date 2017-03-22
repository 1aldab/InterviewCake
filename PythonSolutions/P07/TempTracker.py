# You decide to test if your oddly-mathematical heating company is fulfilling its 
# All-Time Max, Min, Mean and Mode Temperature Guarantee.
# Write a class TempTracker with these methods:
#
# insert()   - records a new temperature
# get_max()  - returns the highest temp we've seen so far
# get_min()  - returns the lowest temp we've seen so far
# get_mean() - returns the mean of all temps we've seen so far
# get_mode() - returns a mode of all temps we've seen so far
# 
# Optimize for space and time. Favor speeding up the getter functions 
# (get_max(), get_min(), get_mean(), and get_mode()) over speeding up insert().

tempMap = {}
minTemp = float('inf')
maxTemp = float('-inf')
meanTemp = float('nan')
modeTemp = float('nan')
modeCount = 0
tempCount = 0

def insert(temp):
	global minTemp, maxTemp, meanTemp, modeTemp, modeCount, tempCount
	if temp < minTemp:
		minTemp = temp
	if temp > maxTemp:
		maxTemp = temp
	if temp in tempMap:
		tempMap[temp] += 1
	else:
		tempMap[temp] = 1
	if tempMap[temp] > modeCount:
		modeCount = tempMap[temp]
		modeTemp = temp
	if tempCount == 0:
		meanTemp = temp
		print "Count \t Min \t Max \t Mean \t Mode"
		print "--------------------------------------"
	else:
		meanTemp += (1.0 * temp - meanTemp) / (tempCount + 1)
	tempCount += 1;
	print "%d \t\t %d \t %d \t %.2f \t %d" % (tempCount, minTemp, maxTemp, meanTemp, modeTemp)

insert(71)
insert(73)
insert(70)
insert(74)
insert(71)
insert(70)
insert(68)
insert(70)
insert(20)
insert(70)
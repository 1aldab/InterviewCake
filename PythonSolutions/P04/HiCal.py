# Your company built an in-house calendar tool called HiCal. You want to add a feature 
# to see the times in a day when everyone is available.
# To do this, you'll need to know when any team is having a meeting. In HiCal, a meeting 
# is stored as an object of a Meeting class with integer variables startTime and endTime. 
# These integers represent the number of 30-minute blocks past 9:00am.
# Write a function mergeRanges() that takes a list of meeting time ranges and returns a 
# list of condensed ranges.

def mergeRanges(intervals):
	intervals.sort()
	n = len(intervals)
	if n == 1:
		return intervals
	merged = []
	i, j = 0, 1
	while (j < n):
		curr = intervals[i]
		beg, end = curr[0], curr[1]
		while (j < n):
			next = intervals[j]
			if (next[0] <= end):
				end = max(end, next[1])
			else:
				break
			j += 1
		merged.append((beg, end))
		i = j
	return merged

def test(intervals):
	merged = mergeRanges(intervals)
	print "%s" % (str(merged))

intervals = [(1,3), (2,4), (5,6)]
test(intervals)
intervals = [(1,2), (2,3)]
test(intervals)
intervals = [(4,6), (3,5), (2,3), (1,3)]
test(intervals)
intervals = [(1,2), (3,4), (5,6)]
test(intervals)
intervals = [(1,3), (1,4), (1,2)]
test(intervals)
intervals = [(1,3)]
test(intervals)



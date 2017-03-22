# Write a function to find the rectangular intersection of two given rectangles.
# Rectangles are defined as dictionaries like this:
#
#  my_rectangle = {
#    'left_x': 1,
#    'bottom_y': 5,
#    'width': 10,
#    'height': 4,
#  }

import math

def rectIntersect(rect1, rect2):
	top1 = (rect1['left_x'], rect1['left_x'] + rect1['width'])
	top2 = (rect2['left_x'], rect2['left_x'] + rect2['width'])
	top = intervalIntersect(top1, top2)

	left1 = (rect1['bottom_y'], rect1['bottom_y'] + rect1['height'])
	left2 = (rect2['bottom_y'], rect2['bottom_y'] + rect2['height'])
	left = intervalIntersect(left1, left2)

	if math.isnan(top[0]) or math.isnan(top[1]) or math.isnan(left[0]) or math.isnan(left[1]):
		top = left = (float('nan'), float('nan'))
	return {
		'left_x' : top[0],
		'bottom_y' : left[0],
		'width' : top[1] - top[0],
		'height' : left[1] - left[0], 
	}


def intervalIntersect(ival1, ival2):
	beg = max(ival1[0], ival2[0])
	end = min(ival1[1], ival2[1])
	if beg <= end:
		return (beg, end)
	else:
		return (float('nan'), float('nan'))

def test(rect1, rect2):
	isect = rectIntersect(rect1, rect2)
	print "(%s, %s, %s, %s)" % (isect['left_x'], isect['bottom_y'], isect['width'], isect['height'])

rect1 = {'left_x' : 0, 'bottom_y' : 5, 'width' : 10, 'height' : 12}
rect2 = {'left_x' : 3, 'bottom_y' : -5, 'width' : 14, 'height' : 12}
test(rect1, rect2)

rect1 = {'left_x' : 0, 'bottom_y' : 5, 'width' : 10, 'height' : 12}
rect2 = {'left_x' : 3, 'bottom_y' : 8, 'width' : 6, 'height' : 7}
test(rect1, rect2)

rect1 = {'left_x' : 0, 'bottom_y' : 5, 'width' : 10, 'height' : 12}
rect2 = {'left_x' : 10, 'bottom_y' : -5, 'width' : 14, 'height' : 10}
test(rect1, rect2)

rect1 = {'left_x' : 0, 'bottom_y' : 5, 'width' : 10, 'height' : 12}
rect2 = {'left_x' : 10, 'bottom_y' : -5, 'width' : 14, 'height' : 12}
test(rect1, rect2)

rect1 = {'left_x' : 0, 'bottom_y' : 5, 'width' : 10, 'height' : 12}
rect2 = {'left_x' : 3, 'bottom_y' : -5, 'width' : 14, 'height' : 8}
test(rect1, rect2)
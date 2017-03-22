class BinaryTreeNode:

	def __init__(self, value, left = None, right = None):
		self.value = value
		self.left = left
		self.right = right

	def insertLeft(self, value):
		self.left = BinaryTreeNode(value)

	def insertRight(self, value):
		self.right = BinaryTreeNode(value)

	def getMinHeight(self):
		if self.left is None or self.right is None:
			return 1
		return min(self.left.getMinHeight(), self.right.getMinHeight()) + 1

	def getMaxHeight(self):
		if self.left is None and self.right is None:
			return 1
		if self.left is None:
			return self.right.getMaxHeight() + 1
		if self.right is None:
			return self.left.getMaxHeight() + 1
		return max(self.left.getMaxHeight(), self.right.getMaxHeight()) + 1

	def isBalanced(self):
		maxHeight = self.getMaxHeight()
		minHeight = self.getMinHeight()
		print "Node %d: maxHeight = %d and minHeight = %d" % (self.value, maxHeight, minHeight)
		return maxHeight - minHeight <= 1

n1 = BinaryTreeNode(1)
n3 = BinaryTreeNode(3)
n2 = BinaryTreeNode(2, n1, n3)
n5 = BinaryTreeNode(5)
n4 = BinaryTreeNode(4, n2, n5)
n7 = BinaryTreeNode(7)
n8 = BinaryTreeNode(8, n7, None)
n6 = BinaryTreeNode(6, n4, n8)
n1.isBalanced()
n2.isBalanced()
n3.isBalanced()
n4.isBalanced()
n5.isBalanced()
n6.isBalanced()
n7.isBalanced()
n8.isBalanced()
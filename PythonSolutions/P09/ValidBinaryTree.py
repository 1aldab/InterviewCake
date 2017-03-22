# Write a function to check that a binary tree
# is a valid binary search tree

class BinaryTreeNode:
	def __init__(self, value, left = None, right = None):
		self.value = value
		self.left = left
		self.right = right

prev = None
def isValidBST(root):
	global prev
	if root is None: return True
	if not isValidBST(root.left): return False 
	if prev != None and root.value <= prev.value: return False 
	prev = root
	if not isValidBST(root.right): return False
	return True

def test(root):
	result = "is" if isValidBST(root) else "is not"
	print "n%d %s a valid BST" % (root.value, result)

# Test for the following tree:
#          6
#        /   \
#       /     \
#      4       8
#     / \     /
#    2   5   7
#   / \
#  1   3
n1 = BinaryTreeNode(1)
n3 = BinaryTreeNode(3)
n2 = BinaryTreeNode(2, n1, n3)
n5 = BinaryTreeNode(5)
n4 = BinaryTreeNode(4, n2, n5)
n7 = BinaryTreeNode(7)
n8 = BinaryTreeNode(8, n7, None)
n6 = BinaryTreeNode(6, n4, n8)
test(n6)
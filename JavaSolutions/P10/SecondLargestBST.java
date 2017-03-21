public class SecondLargestBST {

    public static class BinaryTreeNode {
	
	public int value;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	
	public BinaryTreeNode(int value) {
	    this.value = value;
	}
	
	public BinaryTreeNode insertLeft(int leftValue) {
	    this.left = new BinaryTreeNode(leftValue);
	    return this.left;
	}
	
	public BinaryTreeNode insertRight(int rightValue) {
	    this.right = new BinaryTreeNode(rightValue);
	    return this.right;
	}

	public String toString() {
	    return "n" + this.value;
	}
    }

    public static BinaryTreeNode[] findLargest(BinaryTreeNode root) {
	if (root == null) return null;
	BinaryTreeNode parent = null;
	while (root.right != null) {
	    parent = root;
	    root = root.right;
	}
	return new BinaryTreeNode[] {root, parent};
    }
    
    public static BinaryTreeNode findSecondLargest(BinaryTreeNode root) {
	if (root == null) return null;
	BinaryTreeNode[] lp = findLargest(root);
	BinaryTreeNode largest = lp[0];
	BinaryTreeNode parent = lp[1];
	if (largest.left != null) {
	    BinaryTreeNode[] leftsubtree = findLargest(largest.left);
	    return leftsubtree[0];
	}
	return parent;
    }

    public static void main(String[] args) {
	BinaryTreeNode n7 = new BinaryTreeNode(7);
	BinaryTreeNode n3 = n7.insertLeft(3);
	BinaryTreeNode n10 = n7.insertRight(10);
	BinaryTreeNode n2 = n3.insertLeft(2);
	BinaryTreeNode n6 = n3.insertRight(6);
	BinaryTreeNode n1 = n2.insertLeft(1);
	BinaryTreeNode n5 = n6.insertLeft(5);
	BinaryTreeNode n4 = n5.insertLeft(4);
	BinaryTreeNode n8 = n10.insertLeft(8);
	BinaryTreeNode n11 = n10.insertRight(11);
	BinaryTreeNode n9 = n8.insertRight(9);

	System.out.println("The second largest node for subtree rooted at n7 is: " + findSecondLargest(n7));
	System.out.println("The second largest node for subtree rooted at n3 is: " + findSecondLargest(n3));
    }
}

/* A tree is "superbalanced" if the difference between the depths of any two 
   leaf nodes is no greater than one. Write a function to see if a binary tree 
   is "superbalanced."
*/

import java.lang.Math;

public class BinaryTreeNode {

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

    public int getMinHeight() {
	if (this.left == null && this.right == null) return 1;
	if (this.left == null) return 1 + this.right.getMinHeight();
	if (this.right == null) return 1 + this.left.getMinHeight();
	return 1 + Math.min(this.left.getMinHeight(), this.right.getMinHeight());
    }

    public int getMaxHeight() {
	if (this.left == null && this.right == null) return 1;
	if (this.left == null) return 1 + this.right.getMaxHeight();
	if (this.right == null) return 1 + this.left.getMaxHeight();
	return 1 + Math.max(this.left.getMaxHeight(), this.right.getMaxHeight());
    }

    public boolean isSuperBalanced() {
	if (this.left == null && this.right == null) return true;
	if (this.left == null) return (this.right.getMaxHeight() > 1) ? false : true;
	if (this.right == null) return (this.left.getMaxHeight() > 1) ? false : true;
	int minHeight = Math.min(this.left.getMinHeight(), this.right.getMinHeight());
	int maxHeight = Math.max(this.left.getMaxHeight(), this.right.getMaxHeight());
	System.out.println(this + ".minHeight = " + minHeight + "\t" + this + ".maxHeight = " + maxHeight);
	return (maxHeight - minHeight > 1) ? false : true;
    }

    public static void main(String[] args) {
	BinaryTreeNode n1 = new BinaryTreeNode(1);
	BinaryTreeNode n2 = n1.insertLeft(2);
	BinaryTreeNode n3 = n1.insertRight(3);
	BinaryTreeNode n4 = n2.insertLeft(4);
	BinaryTreeNode n5 = n2.insertRight(5);
	BinaryTreeNode n6 = n3.insertLeft(6);
	BinaryTreeNode n7 = n3.insertRight(7);
	BinaryTreeNode n8 = n4.insertLeft(8);
	BinaryTreeNode n9 = n5.insertLeft(9);
	BinaryTreeNode n10 = n6.insertRight(10);
	BinaryTreeNode n11 = n9.insertLeft(11);

	System.out.println("n1: " + (n1.isSuperBalanced() ? "Yes" : "No"));
	System.out.println("n2: " + (n2.isSuperBalanced() ? "Yes" : "No"));
	System.out.println("n6: " + (n6.isSuperBalanced() ? "Yes" : "No"));
    }
}

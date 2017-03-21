/* Write a function to check that a binary tree ↴ is a valid binary search tree */

import java.util.*;

public class ValidBinaryTree {

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
    }

    public static void dft(BinaryTreeNode n, ArrayList<Integer> nodes) {
	if (n == null) return;
	dft(n.left, nodes);
	nodes.add(n.value);
	dft(n.right, nodes);
    }
    
    public static boolean isValid(BinaryTreeNode n) {
	if (n == null) return true;
	ArrayList<Integer> nodes = new ArrayList<Integer>();
	dft(n, nodes);
	System.out.println("DFT: " + Arrays.toString(nodes.toArray()));
	int prev = nodes.get(0);
	for (int i = 1; i < nodes.size(); i++) {
	    if (nodes.get(i) < prev) return false;
	    prev = nodes.get(i);
	}
	return true;
    }

    static int prev = Integer.MIN_VALUE;
    static boolean valid = true;
    public static void isValidEff(BinaryTreeNode n) {
	if (n == null) return;
	isValidEff(n.left);
	if (n.value < prev) {
	    valid = false;
	    return;
	}
	prev = n.value;
        isValidEff(n.right);
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

	System.out.println(isValid(n7) ? "Valid" : "Invalid");

	isValidEff(n7);
	System.out.println(valid ? "Valid" : "Invalid");
    }
}

/* Use the built-in Stack class to implement a new class MaxStack 
   with a function getMax() that returns the largest element in 
   the stack. getMax() should not remove the item.
 */

import java.util.*;

public class MaxStack {

    private class Item {
	int value;
	int max;

	public Item(int v, int m) {
	    this.value = v;
	    this.max = m;
	}
    }

    private Stack<Item> stack = new Stack<Item>();

    public void push(int v) {
	int prevMax = stack.isEmpty() ? Integer.MIN_VALUE : stack.peek().max;
	int newMax = v > prevMax ? v : prevMax;
	stack.push(new Item(v, newMax));
    }

    public int pop() {
	if (stack.isEmpty()) return Integer.MIN_VALUE;
	return stack.pop().value;
    }

    public int getMax() {
	return stack.peek().max;
    }

    public static void main(String[] args) {
	MaxStack mstack = new MaxStack();
	mstack.push(2);
	System.out.println("getMax(): " + mstack.getMax());
	mstack.push(1);
	System.out.println("getMax(): " + mstack.getMax());
	mstack.push(5);
	System.out.println("getMax(): " + mstack.getMax());
	mstack.push(3);
	System.out.println("getMax(): " + mstack.getMax());
	System.out.println("Popped " + mstack.pop());
	System.out.println("getMax(): " + mstack.getMax());
	System.out.println("Popped " + mstack.pop());
	System.out.println("getMax(): " + mstack.getMax());
	mstack.push(4);
	System.out.println("getMax(): " + mstack.getMax());
	mstack.push(7);
	System.out.println("getMax(): " + mstack.getMax());
	mstack.push(6);
	System.out.println("getMax(): " + mstack.getMax());
    }

}

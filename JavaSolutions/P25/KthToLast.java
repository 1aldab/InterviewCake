/* Write a function kthToLastNode() that takes an integer k and 
   the headNode of a singly linked list, and returns the kth to 
   last node in the list.
 */

public class KthToLast {
    
    public static class LinkedListNode {

	public String value;
	public LinkedListNode next;
	
	public LinkedListNode(String value) {
	    this.value = value;
	}

	public String toString() {
	    return this.value;
	}
    }

    public static void printLinkedList(LinkedListNode head) {
	while (head != null) {
	    System.out.print(head.value + " -> ");
	    head = head.next;
	}
	System.out.println("null");
    }
    
    public static LinkedListNode findKthToLast(LinkedListNode head, int k) {
	LinkedListNode kthToLast = head;
	LinkedListNode last = head;
	for (int i = 0; i <= k; i++) {
	    if (last == null) return null;
	    last = last.next;
	}
	while (last != null) {
	    kthToLast = kthToLast.next;
	    last = last.next;
	}
	return kthToLast;
    }

    public static void main(String[] args) {
	LinkedListNode a = new LinkedListNode("A");
	LinkedListNode b = new LinkedListNode("B");
	LinkedListNode c = new LinkedListNode("C");
	LinkedListNode d = new LinkedListNode("D");
	LinkedListNode e = new LinkedListNode("E");
	LinkedListNode f = new LinkedListNode("F");
	a.next = b;
	b.next = c;
	c.next = d;
	d.next = e;
	e.next = f;

	printLinkedList(a);
	System.out.println("1 to last element is " + findKthToLast(a, 1));
	System.out.println("2 to last element is " + findKthToLast(a, 2));
	System.out.println("3 to last element is " + findKthToLast(a, 3));
	System.out.println("4 to last element is " + findKthToLast(a, 4));
	System.out.println("5 to last element is " + findKthToLast(a, 5));
	String sixth2last = (findKthToLast(a, 6) == null) ? "null" : findKthToLast(a, 6).toString();
	System.out.println("6 to last element is " + sixth2last);
    }
}

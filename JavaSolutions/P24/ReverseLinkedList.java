
public class ReverseLinkedList {

    public static class LinkedListNode {

	public int value;
	public LinkedListNode next;
	
	public LinkedListNode(int value) {
	    this.value = value;
	}
    }

    public static void printLinkedList(LinkedListNode head) {
	while (head != null) {
	    System.out.print(head.value + " -> ");
	    head = head.next;
	}
	System.out.println("null");
    }

    public static LinkedListNode reverseLinkedList(LinkedListNode head) {
	LinkedListNode prev, curr, next;
	prev = head;
	curr = prev.next;
	prev.next = null;
	while (curr != null) {
	    next = curr.next;
	    curr.next = prev;
	    prev = curr;
	    curr = next;
	}
	return prev;
    }

    public static void main(String[] args) {
	LinkedListNode single = new LinkedListNode(0);
	printLinkedList(single);
	LinkedListNode newHead = reverseLinkedList(single);
	printLinkedList(newHead);

	LinkedListNode double1 = new LinkedListNode(100);
	LinkedListNode double2 = new LinkedListNode(1000);
	double1.next = double2;
	printLinkedList(double1);
	newHead = reverseLinkedList(double1);
	printLinkedList(newHead);
	
	LinkedListNode a = new LinkedListNode(1);
	LinkedListNode b = new LinkedListNode(2);
	LinkedListNode c = new LinkedListNode(3);
	LinkedListNode d = new LinkedListNode(4);
	LinkedListNode e = new LinkedListNode(5);
	LinkedListNode f = new LinkedListNode(6);
	a.next = b;
	b.next = c;
	c.next = d;
	d.next = e;
	e.next = f;

	printLinkedList(a);
	newHead = reverseLinkedList(a);
	printLinkedList(newHead);
    }
    
}

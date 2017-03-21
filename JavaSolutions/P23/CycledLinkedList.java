public class CycledLinkedList {

    private static class LinkedListNode {
	String data;
	LinkedListNode next;

	public LinkedListNode(String s) {
	    this.data = s;
	}
    }

    public static boolean containsCycle(LinkedListNode head) {
	LinkedListNode slow = head;
	LinkedListNode fast = head;
	while (fast.next != null) {
	    slow = slow.next;
	    fast = fast.next.next;
	    if (slow == fast) return true;
	}
	return false;
    }

    public static LinkedListNode firstNodeInCycle(LinkedListNode head) {
	LinkedListNode slow = head;
	LinkedListNode fast = head;
	while (fast.next != null) {
	    slow = slow.next;
	    fast = fast.next.next;
	    if (slow == fast) {
		slow = head;
		while (slow != fast) {
		    slow = slow.next;
		    fast = fast.next;
		}
		return slow;
	    }
	}
	return null;
    }

    public static void main(String[] args) {
	LinkedListNode a = new LinkedListNode("A");
	LinkedListNode b = new LinkedListNode("B");
	LinkedListNode c = new LinkedListNode("C");
	LinkedListNode d = new LinkedListNode("D");
	LinkedListNode e = new LinkedListNode("E");
	LinkedListNode f = new LinkedListNode("F");
	LinkedListNode g = new LinkedListNode("G");
	a.next = b;
	b.next = c;
	c.next = d;
	d.next = e;
	e.next = f;
	f.next = g;
	g.next = c;

	if (containsCycle(a)) System.out.println("Linked list contains cycle");
	else System.out.println("Linked list does not contain cycle");

	LinkedListNode fnic = firstNodeInCycle(a);
	if (fnic != null) 
	    System.out.println("First node in cycle is " + fnic.data);
	else
	    System.out.println("No cycle found");
    }
}

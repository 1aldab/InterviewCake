/* Delete a node from a singly-linked list, given only a variable 
   pointing to that node.
 */

public class DeleteNodeFromLL {

    public static class LinkedListNode {

	public String value;
	public LinkedListNode next;
	
	public LinkedListNode(String value) {
	    this.value = value;
	}
    }
    
    public static boolean deleteNode(LinkedListNode node) {
	if (node.next == null)
	    return false;
	else {
	    node.value = node.next.value;
	    node.next = node.next.next;
	    return true;
	}
    }
    
    public static void printLinkedList(LinkedListNode head) {
	while (head != null) {
	    System.out.print(head.value + " -> ");
	    head = head.next;
	}
	System.out.println("null");
    }
    
    
    public static void main(String[] args) {
	LinkedListNode a = new LinkedListNode("A");
	LinkedListNode b = new LinkedListNode("B");
	LinkedListNode c = new LinkedListNode("C");
	
	a.next = b;
	b.next = c;

        printLinkedList(a);
   
        deleteNode(b);

        printLinkedList(a);

    }
}

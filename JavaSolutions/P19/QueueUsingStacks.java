/* Implement a queue with 2 stacks. Your queue should have an enqueue 
   and a dequeue function and it should be "first in first out" (FIFO).
*/

import java.util.*;

public class QueueUsingStacks {

    private int queueSize;
    private Stack<Integer> enq;
    private Stack<Integer> deq;

    public QueueUsingStacks() {
	this.queueSize = 0;
	enq = new Stack<Integer>();
	deq = new Stack<Integer>();
    }
    
    public void enqueue(int k) {
	while (!deq.isEmpty()) {
	    enq.push(deq.pop());
	}
	enq.push(k);
	this.queueSize++;
    }

    public int dequeue() {
	if (this.queueSize == 0) return Integer.MIN_VALUE;
	while(!enq.isEmpty()) {
	    deq.push(enq.pop());
	}
	this.queueSize--;
	return deq.pop();
    }

    public static void main(String[] args) {
	QueueUsingStacks q = new QueueUsingStacks();
	q.enqueue(1);
	q.enqueue(2);
	q.enqueue(3);
	System.out.print(q.dequeue() + ", ");
	q.enqueue(4);
        q.enqueue(5);
	System.out.print(q.dequeue() + ", ");
	System.out.print(q.dequeue() + ", ");
	System.out.print(q.dequeue() + ", ");
	System.out.print(q.dequeue() + ", ");
	System.out.print(q.dequeue() + ", ");
	System.out.println();
    }
    
}

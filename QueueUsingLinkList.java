package com.ds.algo;

public class QueueUsingLinkList {
	
	SingleNode front;
	
	SingleNode rear;
	
	
	public void insert(int data) {
		
		SingleNode node = new SingleNode();
		node.data = data;
		
		if(front == null) {
			front = node;
			rear  = node;
		}
		else 
		{
			SingleNode n = front;
			while(n!=null) {
				if(n.next == null) {
					break;
				}
				n = n.next;
			}
			n.next = node;
			rear = node;
		}
	}
	/**
	 * Insert at Rear/Tail
	 * @param data
	 */
	
	public void enQueue(int data) {
		SingleNode newNode = new SingleNode();
		newNode.data = data;
		if(front == null) { //Queue is Empty
			front = newNode;
			rear = newNode;
		}
		else {
			rear.next = newNode;
			rear = newNode;
		}
	}
	
	/**
	 * Deletion at Front
	 * @return
	 */
	public int deQueue() {
		int x = -1;
		if(front!=null) { //Queue is Not Empty
			x = front.data;
			front = front.next;
		}
		return x;
	}
	
	public int peek() {
		int x = -1;
		if(front!=null) { //Queue is Not Empty
			x = front.data;
		}
		return x;
	}
	
	public int last() {
		int x = -1;
		if(rear!=null) { //Queue is Not Empty
			x = rear.data;
		}
		return x;
	}
	
	public QueueUsingLinkList mergeQueue(QueueUsingLinkList q2) {
		QueueUsingLinkList resultQueue = new QueueUsingLinkList();
		while(this.front!=null || q2.front!=null) {
			if(this.front!=null) {
				resultQueue.enQueue(this.deQueue());
			}
			if(q2.front!=null) {
				resultQueue.enQueue(q2.deQueue());
			}
		}
		return resultQueue;
	}
	
	public static void main(String []args) {
		
		QueueUsingLinkList queue = new QueueUsingLinkList();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		
		QueueUsingLinkList queue2 = new QueueUsingLinkList();
		queue2.enQueue(6);
		queue2.enQueue(7);
		queue2.enQueue(8);
		queue2.enQueue(9);
		
		System.out.println("Peek..." + queue.peek());
		System.out.println("Dequeue..."+ queue.deQueue());
		System.out.println("Peek..." + queue.peek());
		System.out.println("Last..." + queue.last());
		
		queue = new QueueUsingLinkList();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		
		QueueUsingLinkList resultQueue = queue.mergeQueue(queue2);
		
		System.out.println(resultQueue.peek());
		
		//queue.searchKey(3, queue.first);
		
		//queue.reverseList();
	}
	
	
	public SingleNode searchKey(int key, SingleNode head) {
		SingleNode node = null;
		SingleNode previousNode = null;
		SingleNode n = head;
		while(n!=null) {
			if(n.data == key) {
				previousNode.next = n.next;
				n.next = head;
				node = n;
				break;
			}
			previousNode = n;
			n = n.next;
		}
		return node;
	}
	
	public SingleNode reverseList() {
		SingleNode p = front;
		SingleNode q = null;
		SingleNode r = null;
		
		while(p!=null) {
			r = q;
			q = p;
			p = p.next;
			q.next = r;
		}
		
		return q;
	}
	

}

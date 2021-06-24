package com.ds.algo;

public class LinkList {
	
	
	Node head;
	
	Node last;

	public void insert(int data) {
		Node node = new Node();
		node.data = data;
		
		if(head == null) { //If head is Empty
			head = node;
		}
		else 
		{
			Node n = head;
			while(n.next!=null) { //Traverse till last node
				n = n.next;
			}
			
			n.next = node; //Assign the node
			n.next.previous = n;
			last = n.next;
		}
		
	}
	
	public static void main(String args[]) {
		LinkList l = new LinkList();
		
		l.insert(10);
		l.insert(20);
		l.insert(30);
		l.insert(40);
		l.insert(50);
		
		l.display();
		
		System.out.println("Number of Nodes " + l.countNodes());
		System.out.println("Node at 1 is " + l.nodeAt(1).data);
		
		System.out.println("Using Recursion");
		l.displayNodes(l.head);
		
		System.out.println(l.countNodes(l.head));
		
		System.out.println("Searching");
		System.out.println(l.search(20,l.head).data);
		
		//l.insertAt(5, 60);
		System.out.println("After adding Node " + l.last.previous.data);
		l.display();
		
		System.out.println("Going Reverse");
		l.displayReverse();
	}
	
	
	public void display() {
		Node n = head;
		while(n!=null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	public void displayNodes(Node n) {
		if(n == null) {
			return;
		}
		System.out.println(n.data);
		displayNodes(n.next);
	}
	
	
	public int countNodes(Node n) {
		if(n == null) {
			return 0;
		}
		return countNodes(n.next) + 1;
	}
	
	public Node search(int key) {
		Node n = head;
		while(n.next!=null) {
			if(n.data == key) {
				return n;
			}
			n = n.next;
		}
		return null;
	}
	
	public Node search(int key, Node n) {
		if(n == null) {
			return null;
		}
		if(n.data == key) {
			return n;
		}
		return search(key,n.next);
	}
	
	
	public int countNodes() {
		int numberOfNodes = 0;
		Node n = head;
		if(n!=null) {
			numberOfNodes++;
		}
		while(n.next!=null) {
			n = n.next;
			numberOfNodes++;
		}
		return numberOfNodes;
	}
	
	public Node nodeAt(int i) {
		Node n = head;
		int counter = 0;
		if(n!=null) {
			if(i == counter) {
				return n;
			}
		}
		while(n.next!=null) {
			if(counter++ == i) {
				return n;
			}
			n = n.next;
		}
		
		return null;
	}
	/**
	 * 3 Test Cases insert at Head, insert in Middle, insert at End
	 * @param i
	 * @param data
	 */
	public void insertAt(int i, int data) {
		Node node = new Node();
		node.data = data;
		
		Node n = head;
		int counter = 0;
		if(n!=null) {
			if(i == counter) {
				Node tempNode = head;
				head = node;
				node.next = tempNode;
				return;
			}
		}
		while(n.next!=null) {
			if(counter == i-1) { 
				Node tempNode = n.next; //previous node
				n.next = node;
				node.next = tempNode;
				return;
			}
			n = n.next;
			counter++;
		}
		
		if(counter == i-1) { 
			Node tempNode = n.next; //previous node
			n.next = node;
			node.next = tempNode;
		//	last = n;
		}
	}
	
	public Node getLastNode() {
		Node n = head;
		Node lastNode = null;
		while(n!=null) {
			if(n.next == null) {
				lastNode = n;
			}
			n = n.next;
		}
		return lastNode;
	}
	
	public void displayReverse() {
		Node n = head;
		Node node = getLastNode();
		while(node!=null) {
			System.out.println(node.data);
			node = node.previous;
		}
		
	}
	
}

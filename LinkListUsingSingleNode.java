package com.ds.algo;

public class LinkListUsingSingleNode {
	
	SingleNode first;
	SingleNode last;
	
	
	public void insert(int data) {
		SingleNode node = new SingleNode();
		node.data = data;
		
		if(first == null) {
			first = node;
			last = node;
		}
		else {
			//Two way to insert iterate every time element is inserted to last and append
			/*
			 * SingleNode lastNode = first; while(lastNode!=null) { if(lastNode.next ==
			 * null) { break; } lastNode = lastNode.next; } lastNode.next = node;
			 */
			//Keep track of last node and just add it to last node
			last.next = node;
			last = node;
		}
	}
	
	
	public void reverse(SingleNode previousNode, SingleNode currentNode) {
		if(currentNode!=null) {
			reverse(currentNode, currentNode.next);
			currentNode.next = previousNode;
		}
		else {
			first = previousNode;
		}
		
	}
	
	
	public static void main(String []args) {
		LinkListUsingSingleNode l = new LinkListUsingSingleNode();
		l.insert(10);
		l.insert(20);
		l.insert(30);
		l.insert(40);
		l.insert(50);
		l.insert(60);
		SingleNode currentNode = l.first;
		l.reverse(null, currentNode);
		System.out.println("Check List");
		
		
		
	}
	
	

}

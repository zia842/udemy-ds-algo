package com.ds.algo;

public class MyStackUsingLinkList {
	
	SingleNode topNode;
	
	public void push(int data) {
		
		SingleNode node = new SingleNode();
		node.data = data;
		
		if(topNode == null) { //Stack is Empty
			topNode = node;
		}
		else {
			node.next = topNode;
			topNode = node;
		}
	}
	
	public boolean isEmpty() {
		boolean isEmpty = false;
		if(topNode == null) {
			isEmpty = true;
		}
		return isEmpty;
	}
	
	public int pop() throws Exception {
		if(topNode == null) {
			throw new Exception("Stack is Empty");
		}
		int d = topNode.data;
		topNode = topNode.next;
		return d;
	}
	
	
	public static void main(String []args) throws Exception {
		MyStackUsingLinkList stk = new MyStackUsingLinkList();
		stk.push(10);
		stk.push(20);
		stk.push(30);
		stk.push(40);
		stk.push(50);
		System.out.println("Stack Peek.." + stk.pop());
		System.out.println("Check Stack Now..");
	}
	

}

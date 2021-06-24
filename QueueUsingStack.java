package com.ds.algo;

public class QueueUsingStack {
	
	MyStackUsingLinkList stackOne = new MyStackUsingLinkList();
	MyStackUsingLinkList stackTwo = new MyStackUsingLinkList();
	
	public static void main(String []args) throws Exception {
		
		QueueUsingStack qs = new QueueUsingStack();
		qs.add(1);
		qs.add(2);
		qs.add(3);
		qs.add(4);
		qs.add(5);
		System.out.println(qs.remove());
		System.out.println(qs.remove());
		qs.add(6);
		qs.add(7);
		qs.add(8);
		qs.add(9);
		qs.add(10);
		System.out.println(qs.remove());
		System.out.println(qs.remove());
		System.out.println(qs.remove());
		System.out.println(qs.remove());
		System.out.println(qs.remove());
		System.out.println(qs.remove());
		qs.add(11);
		qs.add(12);
		System.out.println(qs.remove());
		System.out.println(qs.remove());
		System.out.println(qs.remove());
		
		
	}
	
	public void add(int data) {
		stackOne.push(data);
	}
	
	public int remove() throws Exception {
		int d = -1;
		if(stackTwo.isEmpty()) {
			while(!stackOne.isEmpty()) {
				stackTwo.push(stackOne.pop());
			}
		}
		if(!stackTwo.isEmpty()) {
			d = stackTwo.pop();
		}
		return d;
	}

}

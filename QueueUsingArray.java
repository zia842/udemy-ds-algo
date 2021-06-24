package com.ds.algo;

public class QueueUsingArray {

	public static void main(String[] args) throws Exception {
			
		QueueWithArray qArr = new QueueWithArray(5);
		/*
		 * qArr.add(2); qArr.add(3); qArr.add(4); System.out.println(qArr);
		 * 
		 * 
		 * System.out.println(qArr.remove()); System.out.println(qArr.remove());
		 * System.out.println(qArr.remove());
		 * 
		 * qArr.add(2); qArr.add(3); qArr.add(4);
		 */
		
		qArr.enqueue(2);
		qArr.enqueue(3);
		qArr.enqueue(4);
		qArr.enqueue(5);
		qArr.enqueue(6);
		
		System.out.println(qArr);
		
		System.out.println(qArr.dequeue());
		System.out.println(qArr.dequeue());
		System.out.println(qArr.dequeue());
		System.out.println(qArr.dequeue());
		
		qArr.enqueue(6);
		qArr.enqueue(6);
		qArr.enqueue(6);
		
		System.out.println(qArr.dequeue());
		System.out.println(qArr.dequeue());
		
		qArr.enqueue(1);
		qArr.enqueue(1);
		
		System.out.println(qArr.dequeue());
		System.out.println(qArr.dequeue());
		
		qArr.enqueue(1);
		qArr.enqueue(1);
		
		System.out.println(qArr.dequeue());
		System.out.println(qArr.dequeue());
		
		System.out.println("Using Array List");
		
		QueueWithArrayList ql = new QueueWithArrayList();
		for(int i=0;i<10;i++) {
			ql.enqueue(Integer.valueOf(i));
		}
		
		for(int i=0;i<10;i++) {
			System.out.println(Integer.valueOf(ql.peek()));
			System.out.println(Integer.valueOf(ql.dequeue()));
		}
		
	}
	
	
	
	

}

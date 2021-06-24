package com.ds.algo;

public class QueueWithArray {
	
	private int qArr[] = null;
	
	private int front =  -1;
	
	private int rear  =  -1;
	
	public QueueWithArray(int size) {
		this.qArr = new int[size];
	}
	
	public boolean isFull() {
		boolean isFull = false;
		if(rear == qArr.length-1) {
			isFull = true;
		}
		return isFull;
	}
	
	public boolean isEmpty() {
		boolean isEmtpy = false;
		if(rear == front) {
			isEmtpy = true;
		}
		return isEmtpy;
	}
	
	public void add(int element) throws Exception{
		//Check if Queue is full
		if(isFull()) {
			throw new Exception("Queue is Full");
		}
		qArr[++rear] = element;
	}
	
	public int remove() throws Exception{
		//Check if Queue is empty
		if(isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		
		return qArr[++front];
	}
	
	public boolean isCQFull() {
		boolean isFull = false;
		if((rear+1)%qArr.length == front) {
			isFull = true;
		}
		return isFull;
	}
	
	public void enqueue(int element) throws Exception{
		if(isCQFull()) {
			throw new Exception("Queue is Full");
		}
		rear = (rear+1)%qArr.length;
		qArr[rear] = element;
	}
	
	public int dequeue() throws Exception{
		//Check if Queue is empty
		if(isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		front  = (front+1)%qArr.length;
		return qArr[front];
	}
	
}

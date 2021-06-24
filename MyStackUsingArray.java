package com.ds.algo;

public class MyStackUsingArray {
	
	int top;
	
	int size;
	
	int arr[];
	
	public MyStackUsingArray(int size) {
		top = -1;
		this.size = size;
		arr = new int[size];
	}
	
	public void push(int data) throws Exception {
		if(top == size-1) {
			throw new Exception("Stack is Full");
		}
		else {
			arr[++top] = data;
		}
	}
	
	public int peek() throws Exception {
		if(top == -1) {
			throw new Exception("Stack is Empty");
		}
		return arr[top];
	}
	
	public int pop() throws Exception {
		if(top == -1) {
			throw new Exception("Stack is Empty");
		}
		int d = arr[top];
		top--;
		return d;
	}
	
	public int peekAtIndex(int index) throws Exception {
		if(top == -1 || top+1-index < 0) {
			throw new Exception("Stack is Empty");
		}
		return arr[top+1-index];
	}
	
	
	public static void main(String []args) throws Exception {
		MyStackUsingArray stack = new MyStackUsingArray(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println("Stack At Index... "+stack.peekAtIndex(2));
		System.out.println("Stack Peek... "+stack.peek());
		System.out.println("Stack Pop... "+stack.pop());
		System.out.println("Stack Peek... "+stack.peek());
		System.out.println("Stack At Index... "+stack.peekAtIndex(3));
		//stack.push(6);
		
	}
	

}

package com.ds.algo;

public class HeapUsingArray {
	
	public static void heapify(int arr[], int n) {
		
		for(int i=(n/2)-1;i>=0;i--) { //Start from first Non-Leaf Node
			
			//i is currently pointing on non-leaf node
			
			
			int j = (2*i) + 1; //Point index on Left Child
			while(j < n-1) {
				
				if(arr[j+1] > arr[i]) {
					j = j + 1; //Point the index to Right Child 
				}
				
				if(arr[j] > arr[i]) { //If either left or right child > parent
					swap(arr, i, j);
					
					i = j; //Move index to its Child
					j = (2*i) + 1; //Move index to its child
				}
				else { //If parent > both child's come out
					break;
				}
				
			}
		}
		
	}
	
	
	public static int delete(int arr[], int n) {
		int x = arr[0]; //First Element is always deleted
		arr[0] = arr[n-1];
		
		for(int i=(n/2)-1;i>=0;i--) { //Start from first Non-Leaf Node
			
			//i is currently pointing on non-leaf node
			
			
			int j = (2*i) + 1; //Point index on Left Child
			while(j < n-1) {
				
				if(arr[j+1] > arr[i]) {
					j = j + 1; //Point the index to Right Child 
				}
				
				if(arr[j] > arr[i]) { //If either left or right child > parent
					swap(arr, i, j);
					
					i = j; //Move index to its Child
					j = (2*i) + 1; //Move index to its child
				}
				else { //If parent > both child's come out
					break;
				}
				
			}
		}
		arr[n-1] = x;
		
		return x;
	}
	
	
	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	public static void main(String []args) {
		int arr[] = {5, 10, 30, 20, 35, 40, 15};
		heapify(arr, arr.length);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
		/*
		 * for(int i=0;i<arr.length;i++) { int l = (2*i) + 1; int r = (2*i) + 2;
		 * 
		 * int leftChild = l < arr.length ? arr[l] : -9999; int rightChild = r <
		 * arr.length ? arr[r] : -9999;
		 * 
		 * System.out.println("Node " + arr[i] + " Left Child " + leftChild +
		 * " Right Child " + rightChild); }
		 */
		
		int d = delete(arr, arr.length);
		System.out.println(d);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}

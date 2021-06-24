package com.ds.algo;

public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fizzBuzz(15);
		
		System.out.println("Sum is " + sum(999));
	}
	
	
	public static void fizzBuzz(int n) {
		for(int i=1;i<=n;i++) {
			if(i%3 == 0 && i%5 == 0) {
				System.out.println("fizzbuzz");
			}
			else if(i%3 == 0) {
				System.out.println("fizz");
			}
			else if(i%5 == 0) {
				System.out.println("buzz");
			}
			else {
				System.out.println(i);
			}
		}
	}
	
	public static int sum(int n) {
		int sum = 0;
		for(int i=1;i<=n;i++) {
			if(i%3 == 0) {
				sum+= i;
			}
			else if(i%5 == 0) {
				sum+= i;
			}
			else {
				System.out.println(i);
			}
		}
		return sum;
	}

}

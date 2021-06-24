package com.ds.algo;

import java.util.HashMap;
import java.util.Map;

public class Fib {
	
	static Map<Integer,Long> fibMap = new HashMap<Integer,Long>();
	static 
	{
		//fibMap.put(Integer.valueOf(0), Long.valueOf(1));
		fibMap.put(Integer.valueOf(1), Long.valueOf(1));
		fibMap.put(Integer.valueOf(2), Long.valueOf(2));
	}
	
	static long evenSUM = 2;
	static long oddSUM = 0;
	
	public static void main(String []args) {
		
		/*
		 * System.out.println(fib(100)); System.out.println(fibRecursion(5));
		 */
		
		//System.out.println(fibRecs(50));
		
		
		  System.out.println(fibRecursion(34)); 
		  System.out.println("Even Sum is "
		  +evenSUM); System.out.print("\033[H\033[2J"); 
		  System.out.flush();
		 
		  System.out.println(fibSum(50));
		 
		
		System.out.println(fibSum());;

	}
	
	/**
	 * Linear Run Time o(n)
	 * @param n
	 * @return
	 */
	public static long fib(int n) {
		long arr[] = new long[n+1];
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i=2;i<arr.length;i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		return arr[n];
	}
	
	/**
	 * Linear Run Time o(n)
	 * @param n
	 * @return
	 */
	public static long fibSum(int n) {
		long arr[] = new long[n+1];
		arr[0] = 0;
		arr[1] = 1;
		long evenSum = 0;
		long oddSum = 0;
		
		for(int i=2;i<arr.length;i++) {
			arr[i] = arr[i-1] + arr[i-2];
			if(i%2==0) {
				evenSum += arr[i];
			}
			else {
				oddSum += arr[i];
			}
			
			if(evenSum > 4000000) {
				//System.out.println("Even Breaking");
				break;
			}
			if(oddSum > 4000000) {
				//System.out.println("Odd Breaking");
				break;
			}
		}
		
		System.out.println("Even Sum " + evenSum);
		System.out.println("Odd Sum " + oddSum);
		return arr[n];
	}
	
	/**
	 * Recursion with Memoization
	 * @param n
	 * @return
	 */
	
	public static long fibRecursion(int n) {
		if(fibMap.containsKey(n)) {
			
			if(fibMap.get(n) < 4000000 && fibMap.get(n)%2 == 0 && n > 2) {
				evenSUM += fibMap.get(n);
				System.out.println("n is "+n + " evenSUM " + evenSUM);
			}
			
			

			return fibMap.get(n);
		}
		
		
		fibMap.put(Integer.valueOf(n-1),Long.valueOf(fibRecursion(n-1)));
		
		fibMap.put(Integer.valueOf(n-2),Long.valueOf(fibRecursion(n-2)));
		
		return fibMap.get(n-1) + fibMap.get(n-2);
	}
	
	/**
	 * Dam Slow because repeatedly calculating same value again & again
	 * @param n
	 * @return
	 */
	
	public static long fibRecs(int n) {
		if(n < 2) {
			return n;
		}
		
		return fibRecs(n-1) + fibRecs(n-2);
	}
	
	public static String fibSum() {
		int sum = 0;
		int x = 1;  // Represents the current Fibonacci number being processed
		int y = 2;  // Represents the next Fibonacci number in the sequence
		while (x <= 4000000) {
			if (x % 2 == 0)
				sum += x;
			int z = x + y;
			x = y;
			y = z;
		}
		return Integer.toString(sum);
	}

}

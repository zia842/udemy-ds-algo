package com.ds.algo;

import java.util.Arrays;

public class Steps {

	public static void main(String[] args) {
		//printStepsDecreasing(21);
		//printStepsIncreasing(21);
		printStepsEnhancedOrderChanged(20);
	}

	public static void printSteps(int n) {
		for (int i = 1; i <= n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 1; j <= i; j++) {
				sb.append("#");
			}
			for (int k = 1; k <= n - i; k++) {
				sb.append(" ");
			}
			System.out.println(sb.toString());
		}
	}

	public static void printStepsEnhanced(int n) {
		for (int i = 1; i <= n; i++) {
			char resultArr[] = new char[n];
			Arrays.fill(resultArr, ' ');
			Arrays.fill(resultArr, 0, i, '#');
			System.out.println(String.valueOf(resultArr));
		}
	}
	
	public static void printStepsEnhancedOrderChanged(int n) {
		for (int i = 1; i <= n; i++) {
			char resultArr[] = new char[n];
			Arrays.fill(resultArr, '#');
			Arrays.fill(resultArr, 0, n-i, ' ');
			System.out.println(String.valueOf(resultArr));
		}
	}
	
	public static void printSteps2D(int n) {
		char resultArr[][] = new char[n][n];
		for (int row=0;row<n;row++) {
			for(int col=0;col<n;col++) {
				if(col <= row) {
					resultArr[row][col] = '#';
				}
				else {
					resultArr[row][col] = ' ';
				}
			}
		}
		for (int row=0;row<n;row++) {
			StringBuilder sb = new StringBuilder();
			for(int col=0;col<n;col++) {
				sb.append(resultArr[row][col]);
			}
			System.out.println(sb.toString());
		}
		
	}
	
	public static void printStepsIncreasing(int n) {
		for(int i=1;i<=n;i++) {
			System.out.println(printStepsRecursive(i));
		}
	}
	
	public static void printStepsDecreasing(int n) {
		for(int i=n;i>=1;i--) {
			System.out.println(printStepsRecursive(i-1));
		}
	}
	
	public static String printStepsRecursive(int n) {
		if(n <= 1) {
			return "#";
		}
		return printStepsRecursive(n-1) + "#";
	}

}

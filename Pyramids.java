package com.ds.algo;

import java.util.Arrays;

/**
 * 
 * @author ziaalkhair.mohammed
 * 
 *         *
 *        *** 
 *       *****  
 *  Number of Rows input 
 *  Columns will be (Number of Rows * 2) - 1
 *  Mid   =  Columns / 2
 *  Start =  Mid - Row Number
 *  End   =  Mid + Row Number
 *  
 *  Example :: 
 *  Number Of Rows =   3
 *  Columns        =   (3 * 2) - 1 = 5
 *  Mid            =   Math.floor(5 / 2) -> 2                       C0 C1 C2 C3 C4        
 *  ROW 0  Start   =   2 - 0 -> 2 ; End = 2 + 0 -> 2                      * 
 *  ROW 1  Start   =   2 - 1 -> 1 ; End = 2 + 1 -> 3                   *  *  *  
 *  ROW 2  Start   =   2 - 2 -> 0 ; End = 2 + 2 -> 4                *  *  *  *  * 
 *  
 *  1. Calculate Number Of Columns
 *  2. Derive Mid
 *  3. Loop thru the array for 0 to number of rows
 *     Initialize Array with Spaces. Calculate Start, End & fill the Array with '#' 
 *  
 */

public class Pyramids {
	
	public static void main(String []args) {
		printPyramid(10);
		System.out.println("\n");
		printCone(10);
	}
	
	public static void printPyramid(int n) {
		//Create an Array
		int rows = n;
		int cols = n * 2 - 1;
		int mid = cols / 2;
		char resultArr[] = new char[cols];
		Arrays.fill(resultArr, ' ');
		
		for(int i=0;i<rows;i++) {
			resultArr[mid-i] = '#';
			resultArr[mid+i] = '#';
			System.out.println(String.valueOf(resultArr));
		}
	}
	
	public static void printCone(int n) {
		//Create an Array
		int rows = n;
		int cols = n * 2 - 1;
		int mid = cols / 2;
		char resultArr[] = new char[cols];
		Arrays.fill(resultArr, '#');
		
		for(int i=0;i<rows;i++) {
			resultArr[mid-i] = ' ';
			resultArr[mid+i] = ' ';
			System.out.println(String.valueOf(resultArr));
		}
	}

}

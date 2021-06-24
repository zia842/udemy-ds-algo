package com.ds.algo;

import java.util.Arrays;

/***
 * 
 * @author ziaalkhair.mohammed
 * 
 * spiral(2)   			1	2
 * 						4	3
 * 
 * spiral(3)			1	2	3
 * 						8	9	4
 * 						7	6	5
 *
 * spiral(4)			1	2	3	4
 * 						12	13	14	5
 * 						11	16	15	6
 * 						10	9	8	7
 *
 * 4 Directions
 * 
 * Move Right -> col ++
 * Move Down  -> row ++
 * Move Left  -> col --
 * Move Up    -> row --
 * 
 * Loop thru if current number < n^2
 * 
 * Move Right if next Col exist and Not Visited (Check if its equal to 0)
 * Move Down if on the last column & next row not visited 
 * Move Left if next column not visited
 * Move Up if next row exist & next row not visited 
 * 
 *  
 * 					
 */

public class Spiral {
	
	public static void main(String []args) {
		
		int resultArr[][] = inWardspiral(5);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<resultArr.length;i++) {
			sb.append("\n");
			for(int j=0;j<resultArr.length;j++) {
				sb.append(resultArr[i][j] + "\t");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static int[][] spiral(int n){
		
		int resultArr[][] = new int[n][n];
		//String spiralArr[][] = new String[n][n];
		int total = n * n;
		int row = 0;
		int col = 0;
		int actual = 0;
		
		while(actual < total) {
			
			resultArr[row][col] = ++actual;
			
			if ((col + 1 < n && resultArr[row][col + 1] == 0
					&& row == 0)  || (row!=0 && row-1 >= 0 && resultArr[row-1][col] != 0 && col + 1 < n  && resultArr[row][col + 1] == 0)) //Move Right
			{
				col++;
			}
			else if(row+1 < n  && resultArr[row+1][col] == 0) //Move Down
			{
				row++;
			}
			else if(col-1 >= 0 && resultArr[row][col-1] == 0) { //Move Left
				col--;
			}
			else if(row-1 >= 0 && resultArr[row-1][col] == 0) { //Move Up
				row--;
			}
		}
		
		return resultArr;
	}
	
	public static int[][] inWardspiral(int n){
		int resultArr[][] = new int[n][n];
		//String spiralArr[][] = new String[n][n];
		int total = n * n;
		int row = 0;
		int col = 0;
		int actual = n * n;
		
		while(actual <= total && actual > 0) {
			
			resultArr[row][col] = actual--;
			
			if ((col + 1 < n && resultArr[row][col + 1] == 0
					&& row == 0)  || (row!=0 && row-1 >= 0 && resultArr[row-1][col] != 0 && col + 1 < n  && resultArr[row][col + 1] == 0)) //Move Right
			{
				col++;
			}
			else if(row+1 < n  && resultArr[row+1][col] == 0) //Move Down
			{
				row++;
			}
			else if(col-1 >= 0 && resultArr[row][col-1] == 0) { //Move Left
				col--;
			}
			else if(row-1 >= 0 && resultArr[row-1][col] == 0) { //Move Up
				row--;
			}
		}
		
		return resultArr;
	}

}

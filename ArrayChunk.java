package com.ds.algo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayChunk {
	
	public static void main(String []args) {
		
		int arr[] = {1,2,3,4,5,6,7,8};
		int size = 3;
		int resultArr[][] = arrayChunk(arr, size);
		
		int rowSize = resultArr.length;
		int colSize = resultArr[0].length;
		
		for(int i=0;i<rowSize;i++) {
			for(int j=0;j<colSize;j++) {
				if(resultArr[i][j] != 0)
					System.out.println("Row Number " + i + " Col Number " + j + " Value " + resultArr[i][j]);
			}
		}
	}
	
	public static void chunk(int []arr, int size) {
		
		List<int[]> resultList = new ArrayList<int[]>();
		int resultArr[] = new int[size];
		
		int end = size;
		int start = 0;
		
		if(arr!=null && arr.length > 0) {
			for(int i=0;i<arr.length;i++) {
				
				if(i >= end) {
					resultList.add(resultArr);
					
					//Re-initialize Array
					end = end + size;
					start = 0;
					resultArr = new int[size];
				}
				
				resultArr[start] = arr[i];
				start++;
				
				if(i == arr.length - 1) {
					resultList.add(resultArr);
				}
				
				System.out.println("Start is " + i + " End is " + end);
			}
		}
	}
	
	public static int [][] chunk2D(int []arr, int size) {
		//int rowSize = (int)Math.ceil((double)arr.length/size);
		int finalArr[][] = new int[(int)Math.ceil((double)arr.length/size)][size];
		int end = size;
		int row = 0;
		int col = 0;
		if(arr!=null && arr.length > 0) {
			for(int i=0;i<arr.length;i++) {
				if(i >= end) {
					//Re-initialize Array
					end = end + size;
					
					//Increment Row 
					row++;
					
					//Reset to first Column
					col = 0;
				}
				finalArr[row][col++] = arr[i];
			}
		}
		return finalArr;
	}
	
	
	public static int [][] arrayChunk(int []arr, int size) {
		
		int rowSize = (int)Math.ceil((double)arr.length/size);
		int finalArr[][] = new int[rowSize][size];
		
		if(arr!=null && arr.length > 0) {
			int index = 0;
			int row = 0;
			
			while (index < index + size  && index < arr.length) {
				finalArr[row++] = Arrays.copyOfRange(arr, index, index + size);
				index += size;
			}
		}
		return finalArr;
	}

}

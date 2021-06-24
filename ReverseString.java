package com.ds.algo;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String []testArr = {"abc","a","!Testing","Greeting!","ab",""};
		
		for(String s : testArr) {
			System.out.println(reverse(s));
		}
		
		System.out.println("Method 2");
	
		for(String s : testArr) {
			System.out.println(reverseTwo(s));
		}
		
	}
	
	
	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		if(s!=null && s.length() > 0) {
			for(int i=s.length()-1;i>=0;i--) {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	
	public static String reverseTwo(String s) {
		String reversed = "";
		if(s!=null && s.length() > 0) {
			for(char c : s.toCharArray()) {
				reversed =  c + reversed;
			}
		}
		return reversed;
	}

}

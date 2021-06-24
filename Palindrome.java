package com.ds.algo;
import java.util.Arrays;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String palindromeArr[] = {"MADAM","ABA","AAB","AB","A","ABBA"};
		Arrays.stream(palindromeArr).forEach(s -> System.out.println(isPalindrome(s)));
		System.out.println("Second Method");
		Arrays.stream(palindromeArr).forEach(s -> System.out.println(isPalindrome2(s)));
	}
	
	public static boolean isPalindrome(String s) {
		return s.equals(reverse(s));
	}
	
	public static String reverse(String s) {
		String reverse = "";
		if(s!=null && s.length() > 0) {
			for(char c : s.toCharArray()) {
				reverse = c + reverse;
			}
		}
		return reverse;
	}
	
	public static boolean isPalindrome2(String s) {
		boolean isPalindrome = true;
		if(s!=null && s.length() > 0) {
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i) != s.charAt(s.length()-1-i)){
					return false;
				}
			}
		}
		return isPalindrome;
	}

}

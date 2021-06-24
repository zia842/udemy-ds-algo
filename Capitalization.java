package com.ds.algo;

public class Capitalization {
	
	public static void main(String []args) {
		String testArr[] = {"hello worlds", "This is my small example string, which I'm going to use for pattern matching.",
				"this, is a test   with spaces! !", "    ", "A B c", "in1between inside 1 test exist ! which is , & * confusing."};
		 for(String s : testArr) {
			 System.out.println(capitalize(s));
		 }
		 
		 System.out.println(capitalize("?hello world"));
	}
	
	
	public static String capitalize(String s) {
		StringBuilder result = new StringBuilder();
		if(s!=null && s.length() > 0) {
			String splitArr[] = s.split("((?<=\\s+)|(?=\\s+)|(?<=\\?)|(?=\\?))"); //Include all the special characters
			for(String sp : splitArr) {
				result.append(sp.substring(0, 1).toString().toUpperCase() + sp.substring(1));
			}
		}
		return result.toString();
	}
	
	
	public static String capitalizeEnhanced(String s) {
		StringBuilder result = new StringBuilder();
		if(s!=null && s.length() > 0) {
			for(int i=0;i < s.length();i++) {
				if((i > 0 && s.charAt(i-1) == ' ') || i == 0) {
					result.append(Character.toUpperCase(s.charAt(i)));
				}
				else 
				{
					result.append(s.charAt(i));
				}
			}
		}
		return result.toString();
	}

}

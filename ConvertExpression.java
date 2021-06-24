package com.ds.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConvertExpression {
	
	static Map<Character, Integer> precedenceMap = new HashMap<Character, Integer>();
	static {
		precedenceMap.put('*', Integer.valueOf(2));
		precedenceMap.put('/', Integer.valueOf(2));
		precedenceMap.put('+', Integer.valueOf(1));
		precedenceMap.put('-', Integer.valueOf(1));
	}
	
	public static void main(String []args) {
		
		System.out.println(inFixToPostFix("a+b*c-d/e"));
		System.out.println(inFixToPostFix("a+b+c*d"));
		
	}
	
	
	public static String inFixToPostFix(String s) {
		StringBuilder result = new StringBuilder();
		Stack<Character> charStk = new Stack<Character>();
		if(s!=null && s.length() > 0) {
			
			int i = 0;
			while(i < s.length()) {
				
				Integer charArrPrecedence = precedenceMap.getOrDefault(s.charAt(i), Integer.valueOf(3));
				
				Integer charStkPrecedence = charStk.isEmpty() ? Integer.valueOf(0) : precedenceMap.getOrDefault(charStk.peek(), Integer.valueOf(3));
				
				if(charStk.isEmpty() || (!charStk.isEmpty() && charArrPrecedence > charStkPrecedence)) {
					charStk.push(s.charAt(i));
					i++;
				}
				else {
					result.append(charStk.pop());
				}
			}
			
			while(!charStk.isEmpty()) {
				result.append(charStk.pop());
			}
		}
		return result.toString();
	}
	
	public static boolean isOperand(Character c) {
		boolean isOperand = true;
		if(c.equals('*')   || c.equals('+')  || c.equals('-')  || c.equals('/')  || c.equals('%')  || c.equals('^') ) {
			isOperand = false;
		}
		return isOperand;
	}

}

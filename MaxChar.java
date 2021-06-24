package com.ds.algo;
import java.util.HashMap;
import java.util.Map;

public class MaxChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String testArr[] = {"test","aaaa","Bobbb","applle","","aaaa 11111"};
		for(String s : testArr) {
			System.out.println(maxChars(s));
		}
	}
	
	
	public static char maxChars(String s) {
		char c=' ';
		Map<String,Integer> charMap = characterMap(s);
		long maxChar = Integer.MIN_VALUE;
		for(Character ch : s.toCharArray()) {
			//maxChar = Math.max(maxChar, charMap.get(ch.toString()));
			if(charMap.get(ch.toString()) >= maxChar) {
				maxChar = charMap.get(ch.toString());
				c = ch;
			}
		}
		return c;
	}
	
	public static Map<String,Integer> characterMap(String s){
		Map<String,Integer> charMap = new HashMap<String,Integer>();
		if(s!=null && s.length() > 0) {
			for(Character c : s.toCharArray()) {
				Integer occurence = charMap.getOrDefault(c.toString(), 0);
				charMap.put(c.toString(), occurence + 1);
			}
		}
		return charMap;
	}

}

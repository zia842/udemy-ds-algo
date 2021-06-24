package com.ds.algo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isAnagramEnhanced("rail safety", "fairy tales"));
		System.out.println(isAnagramEnhanced("RAIL SAFETY!", "fairy tales"));
		System.out.println(isAnagramEnhanced("Hi there", "Bye there"));
		System.out.println(isAnagramEnhanced("Hello", "llehos"));
		System.out.println(isAnagramEnhanced("Hellorrs", "llehosrs"));
		System.out.println(isAnagramEnhanced("ssr", "rrs"));

	}
	
	public static boolean isAnagramEnhanced(String s1, String s2) {
		
		char modifiedCharOne[] = s1.replaceAll("\\W", "").toLowerCase().toCharArray();
		Arrays.sort(modifiedCharOne);
		String modifiedS1 = new String(modifiedCharOne);
		
		char modifiedCharTwo[] = s2.replaceAll("\\W", "").toLowerCase().toCharArray();
		Arrays.sort(modifiedCharTwo);
		String modifiedS2 = new String(modifiedCharTwo);
		
		return modifiedS1.equals(modifiedS2);
	}

	public static boolean isAnagram(String s1, String s2) {
		Map<Character, Integer> mapOne = charMap(s1);
		Map<Character, Integer> mapTwo = charMap(s2);

		if (mapOne.size() != mapTwo.size()) {
			return false;
		} 
		else 
		{
			for(Character c : s1.replaceAll("\\W", "").toLowerCase().toCharArray()) {
				Integer o1 = mapOne.getOrDefault(c, 0);
				Integer o2 = mapTwo.getOrDefault(c, 0);
				if(o1 != o2) {
					return false;
				}
			}
		}
		return true;
		/*
		 * if(mapOne.size() > mapTwo.size()) { //Number of characters Map One > Map Two
		 * iterate over s1 else s2
		 * 
		 * for(Character c : s1.replaceAll("\\W", "").toLowerCase().toCharArray()) {
		 * if(!mapTwo.containsKey(c)) { return false; } }
		 * 
		 * return isCharPresent(s1, mapTwo); } else {
		 * 
		 * for(Character c : s2.replaceAll("\\W", "").toLowerCase().toCharArray()) {
		 * if(!mapOne.containsKey(c)) { return false; } }
		 * 
		 * return isCharPresent(s2, mapOne); }
		 */
	}

	public static Map<Character, Integer> charMap(String s) {
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		if (s != null && s.length() > 0) {
			for (Character c : s.replaceAll("\\W", "").toLowerCase().toCharArray()) {
				Integer occurence = charMap.getOrDefault(c, 0);
				charMap.put(c, occurence + 1);
			}
		}
		return charMap;
	}

}

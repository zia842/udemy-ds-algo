package com.ds.algo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vowels {
	
	public static long vowelCount(String s) {
		long count = 0;
		if(s!=null && s.length() > 0) {
			for(Character c : s.toLowerCase().toCharArray()) {
				if(c == 'a' || c == 'e'
						|| c == 'i' || c == 'o'
						|| c == 'u') {
					count++;
				}
			}
		}
		return count;
	}
	
	public static long vowelCountPattern(String s) {
		long count = 0;
		Pattern patternMatcher = 
				  Pattern.compile("([aeiou]|[AEIOU])");
		if(s!=null && s.length() > 0) {
			Matcher matcher = patternMatcher.matcher(s);
			while(matcher.find()) {
				count++;
			}
		}
		return count;
	}
	
}

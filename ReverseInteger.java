package com.ds.algo;
import java.util.Arrays;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer nums[] = {15,981,500,-15,-90};
		Arrays.stream(nums).forEach(n -> System.out.println(reverseInteger(n)));
		System.out.println("METHOD 2 :: ");
		Arrays.stream(nums).forEach(n -> System.out.println(reverseInt(n)));

	}
	
	public static Integer reverseInteger(Integer num) {
		String s = num.toString();
		String reverse = "";
		for(char c : s.toCharArray()) {
			reverse = c + reverse;
		}
		reverse = reverse.contains("-") ? "-" + reverse.replace("-", "") : reverse;
		return Integer.parseInt(reverse);
	}
	
	public static Integer reverseInt(Integer num) {
		String s = Integer.valueOf(Math.abs(num)).toString();
		String reverse = "";
		for(char c : s.toCharArray()) {
			reverse = c + reverse;
		}
		//return num < 0 ? Integer.parseInt(reverse) * -1 : Integer.parseInt(reverse);
		return Integer.parseInt(reverse) * Integer.signum(num);
	}

}

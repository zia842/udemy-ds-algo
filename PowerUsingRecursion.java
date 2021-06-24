package com.ds.algo;

public class PowerUsingRecursion {
	
	public long power(long m, long n) {
		long result = 1;
		if(n == 0) {
			return result;
		}
		
		return  (long)(m * power(m,n-1));
	}
	
	public static void main(String []args) {
		PowerUsingRecursion p = new PowerUsingRecursion();
		System.out.println(p.power(2, 60));
		System.out.println(p.powerEnhanced(2, 75));
		System.out.println(Math.pow(8, 5));
	}
	
	public long powerEnhanced(long m, long n) {
		long result = 1;
		if(n == 0) {
			return result;
		}
		
		if(n%2==0) {
			return powerEnhanced(m*m,n/2);
		}
		else {
			return (m * powerEnhanced(m*m,((n-1)/2)));
		}
		
	}

}

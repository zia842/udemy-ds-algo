package com.ds.algo;

public class TowerOfHanoi {
	
	public void towerOfHanoi(int n, int a, int b, int c) {
		if(n > 0) {
			towerOfHanoi(n-1, a, c, b);
			System.out.println("Move Disk from " + a +" to " + c);
			towerOfHanoi(n-1, b, a, c);
		}
	}
	
	
	public static void main(String []args) {
		TowerOfHanoi toh = new TowerOfHanoi();
		toh.towerOfHanoi(3, 1, 2, 3);
	}

}

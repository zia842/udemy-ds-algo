package com.ds.algo;

public class MyTree {
	
	
	public static void main(String []args) throws Exception {
		
		//Parent Node
		MyTreeNode rootNode = new MyTreeNode(10);
		
		//Children Node
		MyTreeNode childOne = new MyTreeNode(20);
		MyTreeNode childTwo = new MyTreeNode(30);
		MyTreeNode childThree = new MyTreeNode(40);
		
		//Grand Child's
		MyTreeNode grandChildOne = new MyTreeNode(21);
		MyTreeNode grandChildTwo = new MyTreeNode(22);
		MyTreeNode grandChildThree = new MyTreeNode(23);
		
		MyTreeNode grandChildTwoOne = new MyTreeNode(31);
		MyTreeNode grandChildTwoTwo = new MyTreeNode(32);
		MyTreeNode grandChildTwoThree = new MyTreeNode(33);
		
		MyTreeNode grandChildTwoTwoOne = new MyTreeNode(36);
		MyTreeNode grandChildTwoTwoTwo = new MyTreeNode(37);
		
		grandChildTwoTwo.add(grandChildTwoTwoOne);
		grandChildTwoTwo.add(grandChildTwoTwoTwo);
		
		childOne.add(grandChildOne);
		childOne.add(grandChildTwo);
		childOne.add(grandChildThree);
		
		childTwo.add(grandChildTwoOne);
		childTwo.add(grandChildTwoTwo);
		childTwo.add(grandChildTwoThree);
		
		rootNode.add(childOne);
		rootNode.add(childTwo);
		rootNode.add(childThree);
		
		System.out.println("Number of Children's " + rootNode.size());
		
		
		//childTwo.remove(grandChildTwoTwo);
		MyTreeNode removedNode = rootNode.remove(37);
		
		System.out.println(removedNode.data);
		
		removedNode = rootNode.remove(21);
		
		System.out.println(removedNode.data);
		
	}

}

package com.ds.algo;

public class AVLTree {
	
	public static AVLNode createAVLTree(AVLNode root, int key) {
		if(root == null) {
			root = new AVLNode(key, 1, null, null);
			return root;
		}
		if(key <= root.data) { //Insert Left
			root.leftChild = createAVLTree(root.leftChild, key);
		}
		else { //Insert
			root.rightChild = createAVLTree(root.rightChild, key);
		}
		root.height = height(root);
		
		//Balance Factor
		int rootBalanceFactor = balanceFactor(root);
		int leftBalanceFactor = balanceFactor(root.leftChild);
		int rightBalanceFactor = balanceFactor(root.rightChild);
		if(rootBalanceFactor == -2 && rightBalanceFactor == -1) {
			performRightRotation(root);
		}
		else if(rootBalanceFactor == 2 && leftBalanceFactor == 1) {
			performLeftRotation(root);
		}
		else if(rootBalanceFactor == 2 && leftBalanceFactor == -1) {
			performLeftRightRotation(root);
		}
		
		return root;
	}
	
	public static int height(AVLNode node) {
		int leftChildHeight = 0;
		int rightChildHeight = 0;
		if(node!=null) {
			
			leftChildHeight = node.leftChild!=null ? node.leftChild.height : 0;
			rightChildHeight = node.rightChild!=null ? node.rightChild.height : 0;
		}
		return leftChildHeight > rightChildHeight ? leftChildHeight + 1 : rightChildHeight + 1;
	}
	
	
	public static int balanceFactor(AVLNode node) {
		int balanceFactor = 0;
		if(node!=null) {
			int heightOfLeft  =  node.leftChild!=null ? node.leftChild.height : 0;
			int heightOfRight =  node.rightChild!=null ? node.rightChild.height : 0;
			balanceFactor = heightOfLeft - heightOfRight;
		}
		return balanceFactor;
	}
	
	
	public static AVLNode performLeftRotation(AVLNode node) {
		if(node!=null) {
			AVLNode tempRoot = node.leftChild;
			AVLNode tempLeftRightChild = node.leftChild.rightChild;
			tempRoot.rightChild = new AVLNode(node.data, 1, null, null);
			tempRoot.rightChild.leftChild = tempLeftRightChild;
			node = tempRoot;
		}
		return node;
	}
	
	public static AVLNode performRightRotation(AVLNode node) {
		if(node!=null) {
			AVLNode tempRoot = node.rightChild;
			AVLNode tempRightLeftChild = node.rightChild.leftChild;
			tempRoot.leftChild =  new AVLNode(node.data, 1, null, null);
			tempRoot.leftChild.rightChild = tempRightLeftChild;
			node = tempRoot;
		}
		return node;
	}
	
	public static AVLNode performLeftRightRotation(AVLNode node) {
		if(node!=null) {
			AVLNode tempRoot = node.leftChild.rightChild;
			AVLNode rightChild = new AVLNode(node.data, 1, null, null);
			tempRoot.rightChild = rightChild;
			tempRoot.leftChild = new AVLNode(node.leftChild.data, 1, null, null);
			node = tempRoot;
		}
		return node;
	}
	
	
	
	public static void main(String []args) {
		
		AVLNode root = createAVLTree(null, 30);
		createAVLTree(root, 10);
		createAVLTree(root, 20);
		
		System.out.println(root);
	}

}

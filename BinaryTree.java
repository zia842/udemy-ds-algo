package com.ds.algo;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

    private static final Scanner scanner = new Scanner(System.in);
	 
	public static void main(String[] args) throws IOException {
		
		int inputArr[] = {1,2,3};
		
		//Create Root Node
		BinaryTreeNode node = new BinaryTreeNode(1);
		
		BinaryTreeNode leftNode  =  new BinaryTreeNode(2);
		BinaryTreeNode rightNode =  new BinaryTreeNode(3);
		
		node.left = leftNode;
		node.right = rightNode;
		
		
	    int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }
        
        int rootNodeIndex[][] = new int[indexes.length+1][2];
        rootNodeIndex[0][0] = 1;
    	rootNodeIndex[0][1] = 1;
    	
    	for(int i=0;i<indexes.length;i++) {
    		rootNodeIndex[i+1][0] = indexes[i][0];
    		rootNodeIndex[i+1][1] = indexes[i][1];
		}
    	
    	List<List<Integer>> rootNodeList = new ArrayList<>();
    	List<Integer> rN = new ArrayList<Integer>(); rN.add(1);rN.add(1);
    	rootNodeList.add(0, rN);
    	//Create Tree
    	BinaryTreeNode rootNode = createTree(rootNodeIndex);
    	
    	//Vertical Order
    	verticalOrder(rootNode);
    	
    	//BinaryTreeNode rootNodeOne = createTree(rootNodeList);
    	//printOrder(rootNode);
    	//System.out.println("**********");
    	
    	//Swap Nodes
    	List<List<Integer>> resultList = new ArrayList<>();
    	for(int i=0;i<queries.length;i++) {
    		swapNodes(rootNode, queries[i]);
    		
    		//In Order Traversal
    		List<Integer> inOrderList = new ArrayList<Integer>();
    		inOrder(rootNode, inOrderList);
    		resultList.add(inOrderList);
    	}
    	
    	resultList.toArray();
    	
    	System.out.println("Test..........");

	}
	
	public static BinaryTreeNode createTree(List<List<Integer>> rootNodeIndex) {
		//Create Root Node
		BinaryTreeNode rootNode = new BinaryTreeNode(1);
		rootNode.depth = 1;
		
		//Put it in Queue
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(rootNode);
		
		//Loop Queue until it is empty
		while(queue!=null && !queue.isEmpty()) {
			//Poll Node
			BinaryTreeNode p = queue.poll(); 
			if(p!=null) {
				int childDepth = p.depth + 1;
				int leftChild  = rootNodeIndex.get(p.data).get(0);
				int rightChild = rootNodeIndex.get(p.data).get(1);
				
				if(leftChild > 1) { //Check if Left Child Exist
					BinaryTreeNode tempNode = new BinaryTreeNode(leftChild);
					queue.add(tempNode);
					p.left = tempNode;
					p.left.depth = childDepth;
				}
				if(rightChild > 1) { //Check if Right Child Exist
					BinaryTreeNode tempNode = new BinaryTreeNode(rightChild);
					queue.add(tempNode);
					p.right = tempNode;
					p.right.depth = childDepth;
				}
			}
		}
		
		return rootNode;
	}
	
	public static BinaryTreeNode createTree(int[][] rootNodeIndex) {

		//Create Root Node
		BinaryTreeNode rootNode = new BinaryTreeNode(1);
		rootNode.depth = 1;

		//Put it in Queue
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(rootNode);

		//Loop Queue until it is empty
		while(queue!=null && !queue.isEmpty()) {
			//Poll Node
			BinaryTreeNode p = queue.poll(); 
			if(p!=null) {
				int childDepth = p.depth + 1;
				int leftChild  = rootNodeIndex[p.data][0];
				int rightChild = rootNodeIndex[p.data][1];
				
				if(leftChild > 1) { //Check if Left Child Exist
					BinaryTreeNode tempNode = new BinaryTreeNode(leftChild);
					queue.add(tempNode);
					p.left = tempNode;
					p.left.depth = childDepth;
				}
				if(rightChild > 1) { //Check if Right Child Exist
					BinaryTreeNode tempNode = new BinaryTreeNode(rightChild);
					queue.add(tempNode);
					p.right = tempNode;
					p.right.depth = childDepth;
				}
			}
		}
		
		//System.out.println(rootNode);
		
		return rootNode;

	}
	
	public static void printOrder(BinaryTreeNode rootNode) {
		//Put it in Queue
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		rootNode.depth = 1;
		queue.add(rootNode);
		int previousDepth = 0;
		
	}
	
	public static void swapNodes(BinaryTreeNode rootNode, int level) {
		//Put it in Queue
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(rootNode);
		
		int ctr = 1;
		//Loop Queue until it is empty
		while(queue!=null && !queue.isEmpty()) {
			BinaryTreeNode p = queue.poll(); 
			
			int rotateAt = level * ctr;
			
			if(p!=null) {
				//System.out.println(p.data + " is at depth " + p.depth);
				if(rotateAt == p.depth) {
					BinaryTreeNode tempNode = p.left;
					p.left = p.right;
					p.right = tempNode;
					
					//Increment counter
					if(!queue.isEmpty()) {
						BinaryTreeNode t = queue.peek();
						if(t!=null && t.depth > rotateAt) {
							ctr++;
						}
					}
				}
				
				if(p.left!=null) {
					queue.add(p.left);
				}
				if(p.right!=null) {
					queue.add(p.right);
				}
			}
		}
	}
	
	
	public static void inOrder(BinaryTreeNode rootNode, List<Integer> resultList) {
		if(rootNode!=null) { //Base Condition
			inOrder(rootNode.left, resultList);
			resultList.add(rootNode.data);
			inOrder(rootNode.right, resultList);
		}
	}
	
	
	public static void preOrderIterative(BinaryTreeNode rootNode) {
		Deque<BinaryTreeNode> stack = new ArrayDeque<BinaryTreeNode>();
		BinaryTreeNode t = rootNode;
		while(t!=null || !stack.isEmpty()) {
			if(t!=null) {
				System.out.println(t.data); //Print the data
				//Push current node into stack 
				stack.push(t);
				t = t.left;
			}
			else {
				t = stack.pop();
				t = t.right;
			}
			
		}
	}
	
	/**
	 * Traverse using Level Order & 
	 * Calculate Horizontal Distance of Each Node
	 * Root Node  - Horizontal Distance = 0
	 * Left Node  - Horizontal Distance = Parent Node - 1
	 * Right Node - Horizontal Distance = Parent Node + 1
	 * @param rootNode
	 */
	
	public static void verticalOrder(BinaryTreeNode rootNode) {
		//Put it in Queue
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		rootNode.horizontalDistance = 0; //Root Node Horizontal Distance is 0
		queue.add(rootNode);
		//Loop Queue until it is empty
		while(queue!=null && !queue.isEmpty()) {
			//Poll Node
			BinaryTreeNode p = queue.poll(); 
			if(p!=null) {
				if(p.left!=null) {
					p.left.horizontalDistance = p.horizontalDistance - 1;
					queue.add(p.left);
				}
				if(p.right!=null) {
					p.right.horizontalDistance = p.horizontalDistance + 1;
					queue.add(p.right);
				}
			}
		}	
	}
	
}

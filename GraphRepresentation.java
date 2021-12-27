package com.ds.algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphRepresentation 
{

	public static void main(String []args) {
		
		List<List<Integer>> inputList = new ArrayList<List<Integer>>();
		List<Integer> edgeList = new ArrayList<Integer>();
		edgeList.add(1);
		edgeList.add(2);
		inputList.add(edgeList);
		
		edgeList = new ArrayList<Integer>();
		edgeList.add(1);
		edgeList.add(3);
		inputList.add(edgeList);
		
		edgeList = new ArrayList<Integer>();
		edgeList.add(1);
		edgeList.add(4);
		inputList.add(edgeList);
		
		edgeList = new ArrayList<Integer>();
		edgeList.add(2);
		edgeList.add(1);
		inputList.add(edgeList);
		
		edgeList = new ArrayList<Integer>();
		edgeList.add(2);
		edgeList.add(3);
		inputList.add(edgeList);
		
		edgeList = new ArrayList<Integer>();
		edgeList.add(3);
		edgeList.add(1);
		inputList.add(edgeList);
		
		edgeList = new ArrayList<Integer>();
		edgeList.add(3);
		edgeList.add(2);
		inputList.add(edgeList);
		
		edgeList = new ArrayList<Integer>();
		edgeList.add(3);
		edgeList.add(4);
		inputList.add(edgeList);
		
		edgeList = new ArrayList<Integer>();
		edgeList.add(3);
		edgeList.add(5);
		inputList.add(edgeList);
		
		edgeList = new ArrayList<Integer>();
		edgeList.add(4);
		edgeList.add(1);
		inputList.add(edgeList);
		
		edgeList = new ArrayList<Integer>();
		edgeList.add(4);
		edgeList.add(3);
		inputList.add(edgeList);
		
		edgeList = new ArrayList<Integer>();
		edgeList.add(4);
		edgeList.add(5);
		inputList.add(edgeList);
		
		edgeList = new ArrayList<Integer>();
		edgeList.add(5);
		edgeList.add(3);
		inputList.add(edgeList);
		
		edgeList = new ArrayList<Integer>();
		edgeList.add(5);
		edgeList.add(4);
		inputList.add(edgeList);
		
		edgeList = new ArrayList<Integer>();
		edgeList.add(5);
		edgeList.add(6);
		inputList.add(edgeList);
		
		edgeList = new ArrayList<Integer>();
		edgeList.add(5);
		edgeList.add(7);
		inputList.add(edgeList);
		
		edgeList = new ArrayList<Integer>();
		edgeList.add(6);
		edgeList.add(5);
		inputList.add(edgeList);
		
		edgeList = new ArrayList<Integer>();
		edgeList.add(7);
		edgeList.add(5);
		inputList.add(edgeList);
		
		int numberOfVertex = 7;
		
		System.out.println(inputList);
		
		createAdjacencyMatrix(inputList, numberOfVertex);
		
		createAdjacencyList(inputList, numberOfVertex);
		
		Map<Integer,List<Integer>> vertexAndEdgesMap = compactMap(inputList, numberOfVertex);
		
		breadthFirstSearch(1, vertexAndEdgesMap, numberOfVertex);
		
		System.out.println("**********DEPTH***************");
		depthFirstSearch(1, vertexAndEdgesMap, numberOfVertex);
	}
	
	
	public static int [][] createAdjacencyMatrix(List<List<Integer>> inputList, int numberOfVertex) {
		int [][] adjacencyMatrix = new int[numberOfVertex + 1][numberOfVertex + 1];
		if(inputList!=null && inputList.size() > 0) {
			for(List<Integer> e : inputList) {
				int row = e.get(0);
				int col = e.get(1);
				adjacencyMatrix[row][col] = 1;
			}
		}
		return adjacencyMatrix;
	}
	
	public static LinkedList<Integer>[] createAdjacencyList(List<List<Integer>> inputList, int numberOfVertex) {
		LinkedList<Integer>[] adjacencyList = new LinkedList[numberOfVertex+1];
		LinkedList<Integer> edgeList = new LinkedList<Integer>();
		if(inputList!=null && inputList.size() > 0) {
			for(List<Integer> e : inputList) {
				if(adjacencyList[e.get(0)] == null) {
					edgeList = new LinkedList<Integer>();
					edgeList.add(e.get(1));
				}
				else 
				{
					edgeList = adjacencyList[e.get(0)];
					edgeList.add(e.get(1));
				}
				adjacencyList[e.get(0)] = edgeList;
			}
		}
		return adjacencyList;
	}
	
	public static Map<Integer,List<Integer>> compactMap(List<List<Integer>> inputList, int numberOfVertex) {
		int [] compactArr = new int[numberOfVertex + inputList.size() + 1]; //Actually the formula here is Number of Vertex + (2 * Edges) + 1
		Map<Integer,List<Integer>> vertexAndEdgesMap = new HashMap<>();
		List<Integer> edgeList = new ArrayList<Integer>();
		for(List<Integer> e : inputList) {
			int vertex = e.get(0);
			int edge = e.get(1);
			edgeList = vertexAndEdgesMap.get(vertex);
			if(edgeList == null) {
				edgeList = new ArrayList<Integer>();
			}
			edgeList.add(edge);
			vertexAndEdgesMap.put(vertex, edgeList);
		}
		return vertexAndEdgesMap;
	}
	
	
	public static void breadthFirstSearch(int startingVertex, Map<Integer,List<Integer>> vertexAndEdgesMap, int numberOfVertex) {
		boolean visitedArr[] = new boolean[numberOfVertex+1];
		Queue<Integer> queue = new ArrayDeque<Integer>();
		System.out.print(startingVertex + " ");
		queue.add(startingVertex);
		visitedArr[startingVertex] = true;
		
		while(!queue.isEmpty()) {
			int vertex = queue.poll();
			//Get the edges from Map
			List<Integer> edgeList = vertexAndEdgesMap.get(vertex);
			for(int i=0;i<edgeList.size();i++) {
				int e = edgeList.get(i);
				if(!visitedArr[e]) {
					//Visit it
					System.out.print(e + " ");
					//Add it to Queue
					queue.add(e);
					//Mark visited as true
					visitedArr[e] = true;
					
				}
			}
		}
	}
	
	public static void depthFirstSearch(int startingVertex, Map<Integer,List<Integer>> vertexAndEdgesMap, int numberOfVertex) {
		boolean visitedArr[] = new boolean[numberOfVertex+1];
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		//System.out.print(startingVertex + " ");
		queue.add(startingVertex);
		//visitedArr[startingVertex] = true;
		
		while(!queue.isEmpty()) {
			int vertex = queue.poll();
			//Get the edges from Map
			List<Integer> edgeList = vertexAndEdgesMap.get(vertex);
			for(int i=0;i<edgeList.size();i++) {
				int e = edgeList.get(i);
				if(!visitedArr[e]) {
					//Visit it
					System.out.print(e + " ");
					//Add it to Queue
					queue.offerLast(e);
					//Mark visited as true
					visitedArr[e] = true;
					
				}
			}
		}
	}
	
	
}

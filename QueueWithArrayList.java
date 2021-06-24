package com.ds.algo;

import java.util.ArrayList;
import java.util.List;

public class QueueWithArrayList {
	
	private List<Integer> queueList = null; 
	
	public QueueWithArrayList() {
		queueList = new ArrayList<Integer>();
	}
	
	public void enqueue(Integer element) {
		queueList.add(element);
	}
	
	
	public Integer dequeue() throws Exception {
		if(queueList == null || (queueList!=null && queueList.isEmpty())) {
			throw new Exception("Queue is Empty");
		}
		return queueList.remove(0);
	}
	
	public Integer peek() throws Exception {
		if(queueList == null || (queueList!=null && queueList.isEmpty())) {
			throw new Exception("Queue is Empty");
		}
		return queueList.get(0);
	}

}

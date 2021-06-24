package com.ds.algo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyTreeNode {
	
	int data;
	
	List<MyTreeNode> children;
	
	//MyTreeNode childrenArr[];
	
	public MyTreeNode(int data) {
		this.data = data;
		this.children = new ArrayList<MyTreeNode>();
		//childrenArr = new MyTreeNode[2];
	}
	
	public void add(MyTreeNode childNode) throws Exception{
		if(children == null) {
			throw new Exception("Childrens not initalized");
		}
		children.add(childNode);
	}
	
	public int size() {
		if(children == null) {
			return 0;
		}
		return children.size();
	}
	
	public void remove(MyTreeNode childNode) throws Exception {
		if(children == null) {
			throw new Exception("No Children");
		}
		children.remove(childNode);
	}
	
	public MyTreeNode remove(int data) throws Exception {
		MyTreeNode removedNode = null;
		if(children == null) {
			throw new Exception("No Children");
		}
		
		List<MyTreeNode> childNodes = children;
		Iterator<MyTreeNode> childNodeItr = childNodes.iterator();
		
		while(childNodeItr!=null && childNodeItr.hasNext()) {
			MyTreeNode node = childNodeItr.next();
			if(node.data == data) {
				childNodeItr.remove();
				return node;
			}
			else {
				removedNode = node.remove(data);
				if(removedNode!=null) {
					return removedNode;
				}
			}
		}
		return removedNode;
	}

}

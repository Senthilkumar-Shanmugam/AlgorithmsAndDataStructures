package com.learn.datastructure;

import java.awt.HeadlessException;

public class BTDepthFirstTraversal {

	public static void main(String[] args) {
       BT bst = new BT();
        bst.addNode(50);
	    bst.addNode(30);
		bst.addNode(20);
		bst.addNode(40);
		bst.addNode(70);
		bst.addNode(60);
		bst.addNode(80);
		
		System.out.println("height of the tree:"+height(bst.getRoot()));

	}
	private static void LevelOrderTraversal1(BT btree){
		
	}

	//height of tree - number of edges along the longest path from root node to leaf
	public static int height(BT.Node node){
		if(node==null)
		   return 0;
		   else{
			   int lhight = height(node.getLeft());
			   int rhight = height(node.getRight());
			   
			   if(lhight> rhight)
				   return lhight+1;
			   else
				   return rhight+1;
		   }
		
	}
}


class BT{
	
	public void addNode(int data){
		if(this.root==null){
			this.root=new Node(data);
		}else{
			addNodeInProperPlace(root,data);
		}
	}
	
	private void addNodeInProperPlace(Node node,int data){
		if(data < node.data){//go left
			if(node.left==null){ // if the left is null , create the node and add it to the link
				node.left=new Node(data);
			}else{
				addNodeInProperPlace(node.left, data);
			}
		}else if( data > node.data){// go right
			if (node.right == null){
				node.right = new Node(data);
			}else{
				addNodeInProperPlace(node.right, data);
			}
			
		}
	}

	public Node root;
	
	
	public Node getRoot(){
		return this.root;
	}

	class Node{
		private int data;
		private Node left;
		private Node right;
		
		Node(int data){
			this.data=data;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		
	}
	
	
	
}
package com.learn.datastructure;


class BinaryTree {

	public Node root;

	public Node getRoot() {
		return this.root;
	}

	public void addNode(int data) {
		if (this.root == null) {
			this.root = new Node(data);
		} else {
			addNodeInProperPlace(root, data);
		}
	}

	private void addNodeInProperPlace(Node node, int data) {
		if (data < node.getData()) {// go left
			if (node.getLeft() == null) { // if the left is null , create the node
										// and add it to the link
				node.setLeft(new Node(data));
			} else {
				addNodeInProperPlace(node.getLeft(), data);
			}
		} else if (data > node.getData()) {// go right
			if (node.getRight() == null) {
				node.setRight(new Node(data));
			} else {
				addNodeInProperPlace(node.getRight(), data);
			}
		}
	}
	
	//return the parent node of the serach'd Node
	public static Node searchParent(Node node, int key,Node parent) {
		if (node == null)
			return null;
		else if (node.getData() == key)
			return parent;
		else if (key > node.getData())
			return search(node.getRight(), key,node);
		else if (key <= node.getData())
			return search(node.getLeft(), key,node);
		else
			return null;
	}
	
	public static void removeNode(Node root,int key){
		System.out.println("Removing node from ..");
		
        Node parent = searchParent(root, key, root);
        
        if(parent == null)
        	return;
		System.out.println(" Parent node of key:"+parent.getData());  
		
		Node searchNode = null;
        
		if(parent.getLeft().getData() == key)
			searchNode = parent.getLeft();
		else
			searchNode = parent.getRight();
		
		//leaf node
		 Node left = searchNode.getLeft();
		 Node right = searchNode.getRight();
		 
		 if(left == null && right == null) //remove the link to that node from its parent
		 {
			 parent.setLeft(null);
			 parent.setRight(null);
		 }else if(left != null && right != null){
			 
			 
		 }else{
			 
		 }
	
		  
				
		
		
	}
}

class Node {
	private int data;
	private Node left;
	private Node right;

	Node(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return this.left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return this.right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}

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
	
	
	
	public static Node removeNode(Node root,int key){
		System.out.println("Removing node from ..");
		
        if(root==null)  return root;
        
        if(key < root.getData())
        	root.setLeft(removeNode(root.getLeft(), key));
		else if(key > root.getData())
			root.setRight(removeNode(root.getRight(), key));
		else{//Node to be deleted
			if(root.getLeft()==null)
				return root.getRight();
			else if(root.getRight() == null)
				return root.getLeft();
			
			//node with two children. get inorder successor..smallest right subtree
			
		 root.setData(minValue(root.getRight()));	
			
		// Delete the inorder successor
         root.setRight(removeNode(root.getRight(), root.getData()));	
		}
				
		
		
	}
	
	private static int minValue(Node root){
		int minv = root.getData();
		
		while(root.getLeft()!=null){
			minv=root.getLeft().getData();
			root=root.getLeft();
		}
		return minv;
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

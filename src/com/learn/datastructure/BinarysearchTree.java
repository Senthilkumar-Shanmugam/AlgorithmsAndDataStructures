package com.learn.datastructure;

public class BinarysearchTree {
	Node root = null;

	BinarysearchTree() {
		root = null;
	}

	class Node {
		private int data;
		private Node left;
		private Node right;

		Node(int data) {
			this.data = data;
			left = right = null;
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

	public boolean search(Node node, int key) {
		if (node == null)
			return false;
		else if (node.data == key)
			return true;
		else if (key > node.data)
			return search(node.right, key);
		else if (key <= node.data)
			return search(node.left, key);
		else
			return false;
	}

	void insert(int data) {
		this.root = insertRec(this.root, data);
	}

	Node insertRec(Node node, int data) {
		// if the tree is empty
		if (node == null) {
			node = new Node(data);
			return node;
		} // find the correct location to insert

		if (data < node.data)
			node.left = insertRec(node.left, data);
		if (data > node.data)
			node.right = insertRec(node.right, data);

		// returns the root, unchanged
		return node;
	}
	
	 void inorder()  {
	       inorderRec(root);
	    }
	
	// A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.data);
            inorderRec(root.right);
        }
    }

	public static void main(String[] args) {
		BinarysearchTree bst = new BinarysearchTree();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);

		// print inorder traversal of the BST
		bst.inorder();
		
		System.out.println(" search.."+bst.search(bst.root, 210));
		
	}

}

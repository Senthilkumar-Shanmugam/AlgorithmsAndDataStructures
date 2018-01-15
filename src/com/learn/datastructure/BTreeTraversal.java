package com.learn.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class BTreeTraversal {

	public static void main(String[] args) {
		BinaryTree bst = new BinaryTree();
		bst.addNode(50);
		bst.addNode(30);
		bst.addNode(20);
		bst.addNode(40);
		bst.addNode(70);
		bst.addNode(60);
		bst.addNode(80);
		bst.addNode(56);
		bst.addNode(85);
		bst.addNode(21);
		// level order traversal
		levelOrderTraversal(bst.root);
		System.out.println("\n Pre Order Traversal of binary Tree:");
		preOrder(bst.root);
		System.out.println("\n IN Order Traversal of binary Tree:");
		inOrder(bst.root);
		System.out.println("\n Post Order Traversal of binary Tree:");
		postOrder(bst.root);
	}

	private static void levelOrderTraversal(Node root) {
		System.out.println("Level Order Traversal of binary Tree:");
		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			System.out.print(" " + node.getData());

			if (node.getLeft() != null)
				queue.add(node.getLeft());

			if (node.getRight() != null)
				queue.add(node.getRight());
		}
	}

	private static void preOrder(Node root) {
		if (root != null)
			System.out.print(" " + root.getData());

		if (root.getLeft() != null) //visit all the nodes in left subtree
			preOrder(root.getLeft());

		if (root.getRight() != null) //visit all the nodes in right subtree
			preOrder(root.getRight());
	}

	private static void inOrder(Node root) {
		if (root.getLeft() != null)
			inOrder(root.getLeft());
		if (root != null)
			System.out.print(" " + root.getData());
		if (root.getRight() != null)
			inOrder(root.getRight());
	}

	private static void postOrder(Node root) {
		if (root.getLeft() != null)
			postOrder(root.getLeft());

		if (root.getRight() != null)
			postOrder(root.getRight());

		if (root != null)
			System.out.print(" " + root.getData());

	}

}

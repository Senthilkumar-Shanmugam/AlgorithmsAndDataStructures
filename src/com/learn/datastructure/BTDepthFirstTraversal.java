package com.learn.datastructure;

import java.awt.HeadlessException;

public class BTDepthFirstTraversal {

	public static void main(String[] args) {
		BinaryTree bst = new BinaryTree();
		bst.addNode(50);
		bst.addNode(30);
		bst.addNode(20);
		bst.addNode(40);
		bst.addNode(70);
		bst.addNode(60);
		bst.addNode(80);
		bst.addNode(10);
		bst.addNode(21);
		bst.addNode(22);

		System.out.println("height of the tree:" + height(bst.getRoot()));
		LevelOrderTraversal1(bst.getRoot());

	}

	private static void LevelOrderTraversal1(BinaryTree.Node root) {
		int h = height(root);
		for (int i = 1; i <= h; i++)
			printGivenLevel(root, i);

	}

	private static void printGivenLevel(BinaryTree.Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.getData() + " ");
		else {
			printGivenLevel(root.getLeft(), level - 1);
			printGivenLevel(root.getRight(), level - 1);
		}

	}

	// height of tree - number of nodes(edges?) along the longest path from root
	// node to leaf
	// max depth of a tree using recursive methods
	public static int height(BinaryTree.Node node) {
		int max;
		if (node == null)
			return 0;
		else {
			int lhight = height(node.getLeft());
			int rhight = height(node.getRight());

			if (lhight > rhight)
				max = lhight;
			else
				max = rhight;
			return max + 1;
		}

	}
}


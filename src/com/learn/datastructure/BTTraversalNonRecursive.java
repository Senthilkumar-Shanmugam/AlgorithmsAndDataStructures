package com.learn.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTTraversalNonRecursive {
	public static void main(String[] args) {
		BinaryTree bst = new BinaryTree();
		bst.addNode(50);
		bst.addNode(30);
		bst.addNode(20);
		bst.addNode(40);
		bst.addNode(70);
		bst.addNode(60);
		bst.addNode(80);
		/*bst.addNode(56);
		bst.addNode(85);
		bst.addNode(19);*/
		// preOrder(bst.getRoot());
		// levelOrderTraversal(bst.root);
		//zigzag(bst.root);
		inOrder(bst.getRoot());
		
		bst.removeNode(bst.getRoot(), 80);
	}

	private static void preOrder(Node node) {
		System.out.println("pre order traversal");
		Stack<Node> stack = new Stack<Node>();
		Node current = node;

		/*
		 * while(current != null){ System.out.print(" "+current.getData());
		 * if(current.getRight() != null) stack.push(current.getRight());
		 * current=current.getLeft(); }
		 * 
		 * while(!stack.isEmpty()){ Node tmp = stack.pop();
		 * System.out.print(" "+tmp.getData()); if(tmp.getRight()!=null)
		 * stack.push(tmp.getRight()); if(tmp.getLeft()!=null)
		 * stack.push(tmp.getLeft());
		 * 
		 * }
		 */

		stack.push(node);

		while (!stack.isEmpty()) {
			Node t = stack.pop();
			System.out.print(" " + t.getData());
			if (t.getRight() != null)
				stack.push(t.getRight());
			if (t.getLeft() != null)
				stack.push(t.getLeft());
		}
	}

	private static void zigzag(Node root){
		System.out.println("\nzigzag Order Traversal of binary Tree:");
		 Stack<Node> currentLevel = new Stack<Node>();
		 Stack<Node> nextLevel = new Stack<Node>();
		 boolean leftRight = true;
		 currentLevel.add(root);
		 
	     if(root==null) return;
	     
	     while(!currentLevel.isEmpty()){
	    	 Node t=currentLevel.pop();
	    	 System.out.print(" "+t.getData());
	    	 
	    	
	     if(leftRight){
	    	 if(t.getLeft()!=null)
	    		 nextLevel.add(t.getLeft());
	    	 
	    	 if(t.getRight()!=null)
	    		 nextLevel.add(t.getRight());
	     }else{
	    	 if(t.getRight()!=null)
	    		 nextLevel.add(t.getRight());
	    	 if(t.getLeft()!=null)
	    		 nextLevel.add(t.getLeft());
	     }
	    
	     if(currentLevel.isEmpty()){
	    	 currentLevel=nextLevel;
	    	 nextLevel=new Stack<Node>();
	    	 leftRight=!leftRight;
	    	 
	     }
	 }

	}
	
	private static void inOrder(Node root){
		System.out.println("\nIn order");
		
		if(root==null)
			return;
		Stack<Node> stack = new Stack<Node>();
		Node node=root;
		
		while(true){
		
		 while(node !=null){
			   stack.push(node);
    		   node=node.getLeft();
			}
			
		 if(!stack.isEmpty()){
		    node = stack.pop();
		    System.out.print(" "+node.getData());
		    node=node.getRight();
		}else
			return;
	  }
	}

	private static void levelOrderTraversal(Node root) {
		System.out.println("\nLevel Order Traversal of binary Tree:");
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
}

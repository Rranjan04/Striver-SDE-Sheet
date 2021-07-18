package Day18;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	int val;
	Node right;
	Node left;
	Node(int val){
		this.val = val;
	}
}
public class LevelOrder {
	public static void main(String[] args) {
		 Node rootNode = new Node(1);
		 rootNode.left   = new Node(2);
		 rootNode.right   = new Node(3);
		 rootNode.left.left   = new Node(7);
		 rootNode.left.right   = new Node(6);
		 rootNode.right.left   = new Node(5);
		 rootNode.right.right   = new Node(4);
		 simple(rootNode);
		 System.out.println();
		 zigzag(rootNode);
	}
	static void simple(Node root){
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			Node node = q.poll();
			System.out.print(node.val+" ");
			if(node.left!=null) q.add(node.left);
			if(node.right!=null) q.add(node.right);
		}
	}
	static void zigzag(Node root){
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);
		while(!s1.isEmpty()){
			Node node = s1.pop();
			System.out.print(node.val+" ");
			if(node.left!=null) s2.push(node.left);
			if(node.right!=null) s2.push(node.right);
			if(s1.isEmpty()){
				s1 = s2;
				s2 = new Stack<>();
			}
		}
	}
}

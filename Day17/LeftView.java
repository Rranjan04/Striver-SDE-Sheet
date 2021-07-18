package Day17;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {
	public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(8);
        root.right.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right.left = new Node(14);
		printLeft(root);
	}
	static void printLeft(Node root){
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		System.out.println(root.val);
		while(!q.isEmpty()){
			Node node = q.remove();
			if(!q.isEmpty() && node==null){
				System.out.println(q.peek().val);
				q.add(null);
				continue;
			}
			if(node!=null){
				if(node.left!=null){
					q.add(node.left);
				} 
				if(node.right!=null){
					q.add(node.right);
				}
			}
			
		}
	}
}

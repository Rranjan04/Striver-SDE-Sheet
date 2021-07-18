package Day17;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopView {
	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
		printTop(root);
	}
	static class Pair{
		int x;
		int y;
		Node node;
		Pair(Node node, int x, int y){
			this.node = node;
			this.x = x;
			this.y = y;
		}
	}
	static void printTop(Node root){
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root,0,0));
		HashMap<Integer,Integer> map = new HashMap<>();
		int min  = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		while(!q.isEmpty()){
			Pair p =q.poll();
			if(!map.containsKey(p.x)){
				map.put(p.x, p.node.val);
			}
			min = Math.min(p.x, min);
			max = Math.max(p.x, max);
			if(p.node.left!=null) q.add(new Pair(p.node.left, p.x-1, p.y+1));
			if(p.node.right!=null) q.add(new Pair(p.node.right, p.x+1, p.y+1));
		}
		for(int i=min;i<=max;i++){
			System.out.println(map.get(i));
		}
	}
}

package Day17;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BottomView {
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
	static void bottom(Node root){
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 0, 0));
		HashMap<Integer,Integer> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		while(!q.isEmpty()){
			Pair p = q.poll();
			map.put(p.x, p.node.val);
			min = Math.min(min, p.x);
			max = Math.max(max, p.x);
			if(p.node.left!=null) q.add(new Pair(p.node.left, p.x-1, p.y+1));
			if(p.node.right!=null) q.add(new Pair(p.node.right, p.x+1, p.y+1));
		}
		for(int i=min;i<=max;i++){
			System.out.println(map.get(i));
		}

	}
}

package Day23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class Clone {
	public Node clone(Node node){
		HashMap<Node,Node> map = new HashMap<>();
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		map.put(node, new Node(node.val,new ArrayList<>()));
		while(!q.isEmpty()){
			Node top = q.poll();
			for(Node n:top.neighbors){
				// put neighbours in map
				if(!map.containsKey(n)){
					map.put(n, new Node(n.val,new ArrayList<>()));
					q.add(n);
				}
				map.get(top).neighbors.add(map.get(n));
			}

		}
		return map.get(node);
	}
}

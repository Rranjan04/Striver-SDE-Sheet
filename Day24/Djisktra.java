package Day24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
	int val;
	int weight;
	Pair(int val, int weight){
		this.val = val;
		this.weight = weight;
	}
	public int compareTo(Pair p1){
		return this.weight-p1.weight;
	}
}
public class Djisktra {
	//  shortest distance from source to every node
	// Using pq
	static int[] djisktra(ArrayList<ArrayList<Pair>> graph, int n, int src){
		int[] ans = new int[n];
		Arrays.fill(ans, Integer.MAX_VALUE);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src,0));
		while(!pq.isEmpty()){
			Pair top = pq.poll();
			for(Pair p:graph.get(top.val)){
				if(ans[top.val]+top.weight<ans[p.val]){
					ans[p.val] = ans[top.val] + top.weight;
					pq.add(new Pair(p.val,ans[p.val]));
				}
			}
		}
		return ans;



	}
}

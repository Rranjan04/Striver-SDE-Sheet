package Day24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Prims {
	static void minSpanningTree(ArrayList<ArrayList<Pair>> graph, int n,int src){
		boolean[] mst = new boolean[n];
		int[] key = new int[n];
		Arrays.fill(key, Integer.MAX_VALUE);
		int[] parent = new int[n];
		Arrays.fill(key, -1);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		parent[0] = -1;
		key[0] = 0;
		pq.add(new Pair(0, key[0]));
		for(int count =0;count<n-1;count++){
			// n-1 edges
			int u = pq.poll().val;//finding the min weight vx
			mst[u] = true;//include in mst
			for(Pair p:graph.get(u)){
				if(!mst[p.val] && p.weight<key[p.val]){
					parent[p.val] = u;//parent
					key[p.val] = p.weight;
					pq.add(new Pair(p.val, key[p.val]));
				}
			}
		}
		// O(nlogn)

	}
}

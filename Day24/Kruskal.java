package Day24;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
	static class Node implements Comparable<Node>{
		int wt;
		int u;
		int v;
		Node(int u, int v, int wt){
			this.u = u;
			this.v = v;
			this.wt = wt;
		}
		@Override
		public int compareTo(Node n){
			return this.wt - n.wt;
		}
	}
	static int findParent(int u, int[] parent){
		if(parent[u]==u) return u;
		return parent[u] = findParent(parent[u], parent);
	}
	static void unionFind(int u, int v,int[] parent, int[] rank){
		u = findParent(u, parent);
		v = findParent(v, parent);
		if(rank[u]<rank[v]){
			parent[u] = v;
		}else if(rank[v]<rank[u]){
			parent[v] = u;
		}else{
			parent[v] = u;
			rank[u]++;
		}
	}
	static void find(ArrayList<Node> graph, int n){
		Collections.sort(graph);
		int[] parent = new int[n];
		int[] rank = new int[n];
		for(int i=0;i<n;i++){
			rank[i] = 0;
			parent[i] = i;
		}
		int cost =0;
		ArrayList<Node> mst = new ArrayList<>();
		for(Node node:graph){
			if(findParent(node.u, parent)!=findParent(node.v, parent)){
				// not in the same component
				cost += node.wt;
				mst.add(node);
				// now they become part of the same comp
				unionFind(node.u, node.v, parent, rank);
			}
		}
		System.out.println("Cost is : "+cost);
		
	}
}

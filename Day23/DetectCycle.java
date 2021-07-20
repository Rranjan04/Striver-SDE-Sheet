package Day23;

import java.util.LinkedList;
import java.util.Queue;

public class DetectCycle {
	// detect using BFS
	static boolean isCycle(int[][] graph){
		boolean[] visited = new boolean[graph.length];
		for(int i=0;i<graph.length;i++){
			if(!visited[i]){
				if(help(graph,i,visited)) return true;
			}
			
		}
		return false;
	}
	static class Pair{
		int node;
		int parent;
		Pair(int node, int parent){
			this.node = node;
			this.parent = parent;
		}
	}
	static boolean help(int[][] graph, int src, boolean[] visited){
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(src, -1));
		visited[src] = true;
		while(!q.isEmpty()){
			Pair val = q.remove();
			for(int i=0;i<graph[val.node].length;i++){
				if(graph[val.node][i]!=0){
					if(!visited[i]){
						q.add(new Pair(i, val.node));
						visited[i] = true;
					}else{
						//if it's the parent , ignore
						if(val.parent!=i) return true;
					}
				}
			}
		}
		return false;
	}
	//detect using dfs
	static boolean dfs(int[][] graph){
		boolean[] visited = new boolean[graph.length];
		for(int i=0;i<visited.length;i++){
			if(!visited[i]){
				if(help(graph, i,-1,visited)) return true;
			}
		}
		return false;
	}
	static boolean help(int[][] graph, int src, int parent,boolean[] visited){
		visited[src] = true;
		for(int i=0;i<graph[src].length;i++){
			if(graph[src][i]!=0){
				if(!visited[i]){
					help(graph, i, src,visited);
				}
				else{
					if(i!=parent) return true;
				}
			}
		}
		return false;
	}
}

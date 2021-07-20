package Day23;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
	// BFS
	static boolean isBipartite(int[][] graph){
		// O(N+E)
		int[] visited = new int[graph.length];
		Arrays.fill(visited, -1);
		for(int i=0;i<visited.length;i++){
			if(visited[i]==-1) {
				if(!help(graph,i,visited)) return false;
			}
		}
		return true;
	}
	static boolean help(int[][] graph, int src, int[] visited){
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		visited[src] = 0;
		while(!q.isEmpty()){
			int val = q.remove();
			for(int i=0;i<graph[val].length;i++){
				if(graph[val][i]!=0){
					if(visited[i]!=-1){
						if(visited[val]==visited[i]) return false;
					}else if(visited[val]==1){
						visited[i] = 0;
					}else{
						visited[i] = 1;
					}
				}
			}
		}
		return true;
	}
	// DFS
	static boolean DFS(int[][] graph){
		int[] visited = new int[graph.length];
		Arrays.fill(visited, -1);
		for(int i=0;i<visited.length;i++){
			if(visited[i]==-1){
				if(!helpDFS(graph,i,visited,-1)) return false;
			}
		}
		return true;
	}
	static boolean helpDFS(int[][] graph, int src, int[] visited,int col){
		visited[src] = col==-1?0:col==0?1:0;
		for(int i=0;i<graph[src].length;i++){
			if(graph[src][i]!=0){
				if(visited[i]==visited[src]) return false;
				if(visited[src]==0){
					if (!helpDFS(graph, i, visited, 1)) return false;
				}else{
					if (!helpDFS(graph, i, visited, 0)) return false;
				}
			}
		}
		return true;
	}
	
}

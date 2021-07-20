package Day23;

import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirectedGraph {
	// DFS
	static boolean findDFS(int[][] graph){
		// O(n^n)
		boolean[] visited = new boolean[graph.length];
		boolean[] dfsVisited = new boolean[graph.length];
		for(int i=0;i<graph.length;i++){
			if(!visited[i]){
				if(helpDFS(graph,i,dfsVisited, visited)) return true;
			}
		}
		return false;
	}
	static boolean helpDFS(int[][] graph, int src, boolean[] dfs, boolean[] visited){
		visited[src] = true;
		dfs[src] = true;
		for(int i=0;i<graph[src].length;i++){
			if(!visited[i]){
				helpDFS(graph, i, dfs, visited);
			}else if(dfs[i]) return true;
		}
		dfs[src] = false;//backtrack
		return false;
	}
	// BFS - kahns Algorithm
	//   If we can perform topological sort on graph, cycle isnt present
	static boolean findBFS(int[][] graph){
		int[] inDegree = new int[graph.length];
		for(int i=0;i<graph.length;i++){
			for(int j=0;j<graph[0].length;i++){
				if(graph[i][j]!=0){
					inDegree[j]++;
				}
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<graph.length;i++){
			if(inDegree[i]==0) q.add(i);
		}
		int cnt=0;
		while(!q.isEmpty()){
			int val = q.poll();
			cnt++;
			for(int i=0;i<graph[val].length;i++){
				if(graph[val][i]!=0){
					inDegree[i]--;
					if(inDegree[i]==0){
						q.add(i);
					}
				}
			}
		}
		return cnt==graph.length;
	}
}

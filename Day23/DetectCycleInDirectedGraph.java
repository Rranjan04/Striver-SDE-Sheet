package Day23;

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
	
}

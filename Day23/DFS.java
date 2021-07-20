package Day23;

public class DFS {
	static void dfs(int[][] graph){
		boolean[] visited = new boolean[graph.length];
		for(int i =0;i<graph.length;i++){
			if(!visited[i]){
				help(graph,i,visited);
			}
		}
	}
	static void help(int[][] graph, int src, boolean[] visited){
		visited[src] = true;
		System.out.print(src+" ");
		for(int i=0;i<graph[src].length;i++){
			if(!visited[src] && graph[src][i]!=0){
				help(graph, i, visited);
			}
		}
	}
}

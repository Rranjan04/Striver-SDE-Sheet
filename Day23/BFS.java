package Day23;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	static void bfs(int[][] graph){
		boolean[] visited = new boolean[graph.length];
		for(int i =0;i<graph.length;i++){
			if(!visited[i]){
				help(graph,i,visited);
			}
		}
	}
	static void help(int[][] graph, int src,boolean[]visited){
		Queue<Integer> q = new LinkedList<>();
		visited[src] = true;
		q.add(src);
		while(!q.isEmpty()){
			int val = q.poll();
			System.out.print(val+" ");
			for(int i=0;i<graph[val].length;i++){
				if(!visited[i] && graph[val][i]!=0){
					q.add(i);
					visited[val] = true;
				}
			}
		}

	}
}

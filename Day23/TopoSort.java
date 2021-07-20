package Day23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopoSort {
	// possible for DAG
	public ArrayList<Integer> findDFS(int[][] graph){
		boolean[] visited = new boolean[graph.length];
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<graph.length;i++){
			if(!visited[i]){
				help(graph,i,visited,st);
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		while(!st.isEmpty()){
			ans.add(st.pop());
		}
		return ans;
	}
	public void help(int[][] graph, int src, boolean[] visited, Stack<Integer>st){
		visited[src] = true;
		for(int i=0;i<graph[src].length;i++){
			if(!visited[i] && graph[src][i]!=0){
				help(graph, i, visited, st);
			}
		}
		st.push(src);
	}

	// BFS - Kahns Algorithm DAG
	// Indegree array:
	// Queue -> Indegree having value 0
	static ArrayList<Integer> findBFS(int[][] graph){
		int[] inDegree = new int[graph.length];
		for(int i=0;i<graph.length;i++){
			for(int j=0;j<graph[0].length;i++){
				if(graph[i][j]!=0){
					inDegree[j]++;
				}
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<graph.length;i++){
			if(inDegree[i]==0) q.add(i);
		}
		int cnt=0;
		while(!q.isEmpty()){
			int val = q.poll();
			ans.add(val);
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
		if(cnt!=graph.length) return new ArrayList<>();
		return ans;
	}


}

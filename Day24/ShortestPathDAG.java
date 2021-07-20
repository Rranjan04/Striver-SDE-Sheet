package Day24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Node{
	int vx;
	int weight;
	Node(int vx, int weight){
		this.vx = vx;
		this.weight = weight;
	}
}
public class ShortestPathDAG {
	// weighted
	Stack<Integer> topologicalSort(ArrayList<ArrayList<Node>> graph){
		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[graph.size()];
		for(int i=0;i<visited.length;i++){
			if(!visited[i]){
				help(graph,i,visited,st);
			}
		}
		return st;
	}
	void help(ArrayList<ArrayList<Node>> graph, int src,boolean[] visited, Stack<Integer> st){
		visited[src] = true;
		for(Node x:graph.get(src)){
			if(!visited[x.vx]){
				help(graph, x.vx, visited, st);
			}
		}
		st.push(src);
	}

	void shortestPath(int src, ArrayList<ArrayList<Node>> graph, int N){
		Stack<Integer> st = topologicalSort(graph);
		int[] ans = new int[N];
		Arrays.fill(ans, Integer.MAX_VALUE);
		ans[src] = 0;
		while(!st.isEmpty()){
			int top = st.pop();
			if(ans[top]!=Integer.MAX_VALUE){
				// The node has already been visited via a smaller path
				for(Node node:graph.get(top)){
					ans[node.vx] = Math.min(ans[node.vx], ans[top]+node.weight);
				}
			}
			// else the node isn't reachable yet hence it's neighbors are unreachable
		}
		for(int x:ans){
			System.out.print(x+" ");
		}
	}
	
}

package Day24;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Djisktra {
	static int[] find(int[][] graph){
		Queue<Integer> q = new LinkedList<>();
		int[] ans = new int[graph.length];
		Arrays.fill(graph, Integer.MAX_VALUE);
		int dist = 0;
		while(!q.isEmpty()){
			int len = q.size();
			while(len>0){
				len--;
				int n = q.remove();
				ans[n] = Math.min(ans[n], dist);
				for(int i=0;i<graph[n].length;i++){
					if(graph[n][i]!=0){
						q.add(i);
					}
				}
			}
			dist++;
		}
		return ans;
	}
}

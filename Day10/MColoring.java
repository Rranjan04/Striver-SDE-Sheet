package Day10;

import java.util.List;

public class MColoring {
	public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) 
    {
		int n = G.length;
		if(solve(0, G, color, n, color.length));
		return false;
    }
	private static boolean solve(int node, List<Integer>[] G, int[] color, int n, int m){
		if(node==n){
			//colored nodes == n
			return true;
		}
		for(int i=0;i<=m;i++){
			if(isValid(node,G,color,n,i)){
				color[node] = i;
				if(solve(node, G, color, n, m)) return true;
				color[node] = 0;
			}
		}
		return false;
	}
	private static boolean isValid(int node, List<Integer>[] G, int[] color, int n, int col){
		for(int it: G[node]){
			if(color[it]==col) return false;
		}
		return true;
	}
}

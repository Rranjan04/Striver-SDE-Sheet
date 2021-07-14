package Day10;

import java.util.ArrayList;

public class RatInAMaze {
	public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        help(0,0,m,n,res,"",visited);
        return res;
    }
    public static void help(int i, int j,int[][] m, int n, 
    ArrayList<String> res, String ans,boolean[][] visited)
    {   
        if(i<0||i>=n||j<0||j>=n||m[i][j]==0||visited[i][j]) return;
        if(i==n-1 && j==n-1){
            res.add(ans);
            return;
        }
        visited[i][j] = true;
        help(i+1,j,m,n,res,ans+"D",visited);
        help(i,j-1,m,n,res,ans+"L",visited);
        help(i,j+1,m,n,res,ans+"R",visited);
        help(i-1,j,m,n,res,ans+"U",visited);
        visited[i][j] = false;
        
    }
}

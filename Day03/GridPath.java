package Day03;

import java.util.Arrays;

public class GridPath {
	public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] t:dp){
            Arrays.fill(t,-1);
        }
        return help(0,0,m,n,dp);
    }
    public int help(int i, int j,int m, int n,int[][] dp){
        if(i<0||i>=m||j<0||j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int right = help(i,j+1,m,n,dp);
        int bottom=help(i+1,j,m,n,dp);
        return dp[i][j] = right+bottom;
    }
}

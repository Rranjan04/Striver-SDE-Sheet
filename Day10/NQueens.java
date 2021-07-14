package Day10;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        fill(0,0,n,res,visited);
        return res;
    }
    public void fill(int row , int qsf,int n, List<List<String>> res, boolean[][] visited){
        if(qsf==n){
            ArrayList<String> ans = new ArrayList<>();
            for(int i=0;i<n;i++){
                String str = "";
                for(int j=0;j<n;j++){
                    str+=visited[i][j]?"Q":".";
                }
                ans.add(str);
            }
            res.add(new ArrayList<>(ans));
            return;
        }   
        for(int i=0;i<n;i++){
           if(!visited[row][i] && isValid(row,i,visited)){
                visited[row][i] = true;
                fill(row+1,qsf+1,n,res,visited);
                visited[row][i] = false;
           }
        }
    }
    public boolean isValid(int row, int col, boolean[][] visited){
        // row
        for(int i=0;i<row;i++){
            if(visited[i][col]) return false;
        }
        for(int j=0;j<visited.length;j++){
            if(visited[row][j]) return false;
        }
        //diagonal 1
        int i= row,  j = col;
        while(i>=0 && j>=0){
            if(visited[i][j]) return false;
            i--;
            j--;
        }
        i= row;
        j = col;
//         diagonal 2
        while(i>=0 && j<visited.length){
            if(visited[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }
}

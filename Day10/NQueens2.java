package Day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens2 {
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] x:board){
            Arrays.fill(x,'.');
        }
        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2*n-1];
        boolean[] rdiag = new boolean[2*n-1];
        solve(0,board,ans,diag,rdiag,col);
        return ans;
    }
    public void solve(int row,char[][] board, List<List<String>> res, boolean[] diag, boolean[]rdiag ,boolean[] col){
        if(row==board.length){
            res.add(convert(board));
            return;
        }
        for(int i=0;i<board.length;i++){
            if(!diag[row+i] && !rdiag[row-i+board.length-1] && !col[i]){
                board[row][i] = 'Q';
                diag[row+i] = true;
                rdiag[row-i+board.length-1] = true;
                col[i] = true;
                solve(row+1,board,res,diag,rdiag,col);
                board[row][i] = '.';
                diag[row+i] = false;
                rdiag[row-i+board.length-1] = false;
                col[i] = false;
            }
        }
    }
    public ArrayList<String> convert(char[][] board){
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String str = new String(board[i]);
            ans.add(str);
        }
        return ans;
    }
}

package Day10;

public class Sudoku {
	public void solveSudoku(char[][] board){
		if(board==null || board.length==0) return;
		solve(board);
	}
	public boolean solve(char[][] board){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board.length;j++){
				//checking for spaces to be filled
				if(board[i][j]=='.'){
					for(char d='1';d<='9';d++){
						// trying all combinations
						if(isValid(board, i, j, d)){
							board[i][j] = d;
							
							if(solve(board)) return true;
							else{
								board[i][j] = '.';
							}
						}
					}return false;// none of the combinations are possible
				}
			}
		}
		return true;
	}
	public boolean isValid(char[][] board, int r, int c,char d){
		for(int i=0;i<9;i++){
			if(board[i][c]==d) return false;
			if(board[r][i]==d) return false;
			if(board[3*(r/3)+i/3][3*(c/3)+i%3]==d) return false;
		}
		return true;
	}
}

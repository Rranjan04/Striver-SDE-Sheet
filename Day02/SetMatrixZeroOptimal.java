package Day02;

public class SetMatrixZeroOptimal {
	public static void main(String[] args) {
		
	}
	// maintaining markers in the matrix itself-int the first row and cols
	static void update(int[][] matrix){
		boolean rowFlag = false;
		boolean colFlag = false;
		int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && matrix[i][j]==0){
                    rowFlag =true;
                }
                if(j==0 && matrix[i][j]==0){
                    colFlag = true;
                }
                if(matrix[i][j]==0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(rowFlag){
            for(int i=0;i<m;i++){
                matrix[0][i] =0 ;
            }
        }
        if(colFlag){
            for(int j=0;j<n;j++){
                matrix[j][0] = 0;
            }
        }

	}
}

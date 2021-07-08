package Day02;

public class RotateMatrix {
	public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int[] row:matrix){
            reverse(row,0,row.length-1);
        }
    }
    private void reverse(int[] row,int start, int end){
        while(start<end){
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;
            start++;
            end--;
        }
    }
}

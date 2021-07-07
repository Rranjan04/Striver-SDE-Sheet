package Day01;

public class MergeTwoSortedInConstantSpaceOptimal {
	public static void main(String[] args) {
		
	}
	static void merge(int[] a1,int[] a2){
		int m = a1.length;
		int n = a2.length;
		for(int i=0;i<m;i++){
			if(a1[i]>a2[0]){
				//swap
				int temp = a1[i];
				a1[i] = a2[0];
				a2[0] = temp;
				//move y0 to correct position
				int key = a2[0];
				int j;
				for(j=1;j<n && a2[j]<a2[0];j++){
					a2[j-1] = a2[j];
				}
				a2[j-1] = key;
			}
		}
	}
}

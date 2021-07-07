package Day01;
public class SortAnArrayOf01And2{
	public static void main(String[] args) {
		int[] arr = {0,1,2,0,1,0,0,0,2,1,2,1,2,1,0,1,0,0,2};
		sort(arr, arr.length);
		for(int x:arr){
			System.out.print(x+" ");
		}
	}
	static void sort(int[] arr, int n){
		int i=0 ,j=0 ,k=n-1;
		while(j<k){
			if(arr[j]==1){
				j++;
			}
			else if(arr[j]==0){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j++;
			}
			else{
				int temp = arr[k];
				arr[k] = arr[j];
				arr[j] = temp;
				k--;
			}
		}
	}
}
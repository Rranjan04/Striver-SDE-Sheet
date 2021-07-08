package Day02;

public class NextPermutation {
	public static void main(String[] args) {
		
	}
	//algorithm:
	// 1) iterate from the back find i such that a[i]<a[i+1]
	// 2) iterate from the back find j in array such that a[j]>a[i]
	// 3) Swap a[i] and a[j]
	// 4) reverse everything after index i
	public void nextPermutation(int[] arr) {
        int i=arr.length-2,j=arr.length-1;
        for(;i>=0;i--){
            if(arr[i]<arr[i+1]) break;
        }
        if(i!=-1){
            for(;j>=0;j--){
                if(arr[i]<arr[j]) break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        reverse(arr,i+1,arr.length-1);
    }
    private void reverse(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

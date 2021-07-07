package Day01;

public class RepeatAndMissingNumber {
	public static void main(String[] args) {
		int[] arr = { 7, 3, 4, 5, 5, 6, 2 };
        int n = arr.length;
		find(arr, n);
	}
	static void find(int[] arr, int n){
		for(int i=0;i<n;i++){
			int index = Math.abs(arr[i]);
			if(arr[index-1]>0){
				arr[index-1] = -arr[index-1];
			}else{
				System.out.println("Repeating Element: "+index);
			}
		}
		//repeating number
		for(int i=0;i<n;i++){
			if(arr[i]>0){
				System.out.println("Missing Element: "+(i+1));
			}
		}
	}
}

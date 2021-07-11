package Day07;

public class RemoveDuplicatesInSortedArray {
	public int remove(int[] arr){
		if(arr.length==0||arr.length==1) return arr.length;
		int j = 0;
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]!=arr[i+1]){
				arr[j++] = arr[i];
			}
		}
		arr[j++] = arr[arr.length-1];
		return j;
	}
}

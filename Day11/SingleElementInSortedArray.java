package Day11;

public class SingleElementInSortedArray {
	public int find(int[] arr){
		//             shrink the left half;
//             Left Half: 1st Instance: Even; 2nd Instance: Odd
//             Right Half: 1st Instance: Odd; 2nd Instance: Even
		int low =0;
		int high = arr.length-2;//to help the terminating condition
		while(low<=high){
			int mid = low+(high-low)/2;
			if(arr[mid]==arr[mid^1]){
				//condition will be false for right half
				low = mid+1;
			}else{
				high = mid-1;
			}
		}
		return arr[low];
	}
}

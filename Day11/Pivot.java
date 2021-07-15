package Day11;

public class Pivot {
	public int search(int[] arr, int target) {
		//         2 cases : left half is sorted OR right half is sorted
				int low =0;
				int high = arr.length-1;
				while(low<=high){
					int mid = low+(high-low)/2;
					if(arr[mid]==target){
						return mid;
					}else if(arr[mid]>=arr[low]){
						//left array is sorted
						if(target>=arr[low] && target<arr[mid]){
							//target lies in sorted array
							high = mid-1;
						}else{
							//target lies in the right array
							low = mid+1;
						}
					}else{
						if(target>arr[mid] && target<=arr[high]){
							low = mid+1;
						}else{
							high = mid-1;
						}
					}
				}
				return -1;
			}
}

package Day03;

import java.util.Arrays;

public class ReversePairs {
	public static void main(String[] args) {
		int[] arr = {40,25,19,12,9,6,2};
		System.out.println(mergeSort(arr, 0, arr.length-1));
	}
	static int mergeSort(int[] arr, int low, int high){
		if(low>=high) return 0;
		int mid = low+(high-low)/2;
		int l = mergeSort(arr, low, mid);
		l+=mergeSort(arr, mid+1, high);
		l+=merge(arr,low,mid,high);
		return l;
	}
	static int merge(int[] arr, int low, int mid, int high){
		//count pairs before merging
		int count = 0;
		int j=mid+1;
		for(int i=low;i<=mid;i++){
			while(j<=high && arr[i]>2*(long)arr[j]){
				j++;
			}
			count+= j-(mid+1);
			j = mid+1;
		}
		int[] left = Arrays.copyOfRange(arr, low, mid+1);
		int[] right = Arrays.copyOfRange(arr, mid+1, high+1);
		int i=0,k=low;
		j=0;
		while(i<left.length && j<right.length){
			if(left[i]<right[j]){
				arr[k++] = left[i++];
			}else{
				arr[k++] = right[j++];
			}
		}
		while(i<left.length) arr[k++] = left[i++];
		while(j<right.length) arr[k++] = right[j++];
		return count;
	}
}

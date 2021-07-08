package Day02;

import java.util.Arrays;

public class InversionOfArray {
	public static void main(String[] args) {
		System.out.println(findInversions(new int[]{8,4,2,1},0,3));
	}
	static int findInversions(int[] arr, int low, int high){
		if(low>=high){
			return 0;
		}
		int mid = low+(high-low)/2;
		int l = findInversions(arr, low, mid);
		int r = findInversions(arr, mid+1, high);
		int m = merge(arr,low,mid,high);
		return l+r+m;
	}
	static int merge(int[] arr, int low, int mid, int high){
		int[] left = Arrays.copyOfRange(arr, low, mid+1);
		int[] right = Arrays.copyOfRange(arr, mid+1, high+1);
		int i =0,j=0,k=low,swap=0; 
		while(i<left.length && j<right.length){
			if(left[i]<right[j]) {
				arr[k++] = left[i++];
			}
			else {
				arr[k++] = right[j++];
				swap+=(mid+1)-(low+i);//low+i==current index of left element
			}
		}
		while(i<left.length) arr[k++] = left[i++];
		while(j<right.length) arr[k++] = right[j++];
		return swap;
	}
}

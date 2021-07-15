package Day11;

import java.util.Arrays;

public class AggressiveCows {
	public static void main(String[] args) {
		System.out.println(find(2, 3, new int[]{1,2,8,4,9}));
	}
	static int find(int n, int c, int[] arr){
		int min = 0;
		int sum =0;
		Arrays.sort(arr);
		for(int x:arr){
			sum+=x;
			min = Math.min(min, x);
		}
		int low = min, high = sum;
		int ans = -1;
		while(low<=high){
			int mid = (low+high)/2;
			if(isValid(mid,c,arr)){
				ans = mid;
				low = mid+1;
			}else{
				high = mid-1;
			}
		}
		return ans;
	}
	static boolean isValid(int mid, int c, int[] arr){
		int count = 1;
		int last = arr[0];
		int idx = 1;
		while(idx<arr.length){
			if(arr[idx]-last>=mid){
				count++;
				last = arr[idx];
			}
			idx++;
		}
		return count>=c;
	}
}

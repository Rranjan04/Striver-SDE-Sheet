package Day14;

import java.util.Stack;

public class SlidingWindowMax {
	public static void main(String[] args) {
		int[] ans = max(new int[]{9,7,2,4,6,8,2,1,5}, 3);
		for(int x:ans){
			System.out.print(x+" ");
		}
	}
	static int[] max(int[] arr,int k){
		int[] ngr = ngr(arr);
		int[] ans = new int[arr.length-k+1];
		int j =0;
		for(int i=0;i<=arr.length-k;i++){
			if(j<i){
				j = i;
			}
			while(ngr[j]<i+k){
				j = ngr[j];
			}
			ans[i] = arr[j];
		}
		return ans;

	}
	static int[] ngr(int[] arr){
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[n];
		for(int i=n-1;i>=0;i--){
			while(!st.isEmpty()&& arr[st.peek()]<=arr[i]){
				st.pop();
			}
			if(st.isEmpty()) ans[i] = n+10;
			else ans[i] = st.peek();
			st.push(i);
		}
		return ans;

	}
}

package Day14;

import java.util.Stack;

public class MaxAreaHistogram {
	public static void main(String[] args) {
		System.out.println(max(new int[]{6,2,5,4,5,1,6}));
	}
	static int max(int[] arr){
		int[] nsr = nsr(arr);
		int[] nsl = nsl(arr);
		int max = 0;
		for(int i=0;i<arr.length;i++){
			max = Math.max(max, (nsr[i]-nsl[i]-1)*arr[i]);
		}
		return max;
	}
	static int[] nsr(int[] arr){
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[n];
		for(int i=n-1;i>=0;i--){
			while(!st.isEmpty()&& arr[st.peek()]>=arr[i]){
				st.pop();
			}
			if(st.isEmpty()) ans[i] = n;
			else ans[i] = st.peek();
			st.push(i);
		}
		return ans;

	}
	static int[] nsl(int[] arr){
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[n];
		for(int i=0;i<n;i++){
			while(!st.isEmpty()&& arr[st.peek()]>=arr[i]){
				st.pop();
			}
			if(st.isEmpty()) ans[i] = -1;
			else ans[i] = st.peek();
			st.push(i);
		}
		return ans;
	}
}

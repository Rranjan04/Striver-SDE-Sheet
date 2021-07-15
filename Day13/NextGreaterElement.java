package Day13;

import java.util.Stack;

public class NextGreaterElement {
	public int[] nge(int[] nums){
		int n = nums.length;
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[n];
		for(int i=2*n-1;i>=0;i--){
			// Circular Array
			while(!st.isEmpty() && st.peek()<=nums[i%n]){
				st.pop();
			}
			if(i<n){
				if(st.isEmpty()) ans[i] = -1;
				else ans[i] = st.peek();
			}
			st.push(nums[i%n]);
		}
		return ans;
	}
}

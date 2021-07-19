package Day22;

import java.util.Deque;
import java.util.LinkedList;

public class DistinctNumbers {
	public int[] maxSlidingWindow(int[] arr, int k) {
        int[] ans = new int[arr.length-k+1];
        Deque<Integer> dq = new LinkedList<>();
        int n = arr.length;
        int i=0;
        for(;i<k;i++){
            while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        for(;i<n;i++){
            ans[i-k] = arr[dq.peekFirst()];
//             removing elements from previous window
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.removeFirst();
            }
//             adding new elemets
            while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
//         last window is yet to be updated
        ans[i-k] = arr[dq.peekFirst()];
        return ans;
    }
}

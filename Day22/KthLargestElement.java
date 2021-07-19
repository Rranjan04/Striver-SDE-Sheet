package Day22;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestElement {
	public static void main(String[] args) {
		int n = 6;
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		int k = 4;
		System.out.println(find(k, arr, n));
	}
	static ArrayList<Integer> find(int k, int[] arr, int n){
		ArrayList<Integer> ans = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<n;i++){
			if(pq.size()<k){
				pq.add(arr[i]);
			}
			else{
				if(pq.peek()<arr[i]){
					pq.remove();
					pq.add(arr[i]);
				}
			}
			if(pq.size()<k){
				ans.add(-1);
			}else{
				ans.add(pq.peek());
			}
		}
		return ans;
	
	}
}

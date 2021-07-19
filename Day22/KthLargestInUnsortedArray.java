package Day22;

import java.util.PriorityQueue;

public class KthLargestInUnsortedArray {
	public static void main(String[] args) {
		System.out.println(find(new int[]{1,0,9,87,5,4,6,732,45}, 2));
	}
	static int find(int[] arr, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int x:arr){
			if(pq.size()<k){
				pq.add(x);
			}else{
				if(pq.peek()<x){
					pq.remove();
					pq.add(x);
				}
			}
		}
		return pq.peek();
	}
}

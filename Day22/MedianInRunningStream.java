package Day22;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInRunningStream {
	PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
	PriorityQueue<Integer> pq2 = new PriorityQueue<>();
	public void add(int val){
		if(pq2.size()>0 && val>pq2.peek()){
			pq2.offer(val);
		}else{
			pq1.offer(val);
		}
		if(pq1.size()-pq2.size()==2){
			// balancing- l>r
			pq2.offer(pq1.poll());
		}else if(pq2.size()-pq1.size()==2){
			// r>l
			pq1.offer(pq2.poll());
		}
	}
	public int remove(){
		if(size()==0){
			System.out.println("Underflow");
			return -1;
		}
		if(pq1.size()>=pq2.size()){
			return pq1.poll();
		}
		return pq2.poll();
	}
	public int peek(){
		if(size()==0){
			System.out.println("Underflow");
			return -1;
		}
		if(pq1.size()>=pq2.size()){
			return pq1.peek();
		}
		return pq2.peek();
	}
	public int size(){
		return pq1.size()+pq2.size();
	}
}

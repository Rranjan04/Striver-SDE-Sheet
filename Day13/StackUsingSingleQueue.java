package Day13;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingSingleQueue {
	class MyStack {
		private Queue<Integer> q;
		/** Initialize your data structure here. */
		public MyStack() {
			q = new LinkedList<>();
		}
		
		/** Push element x onto stack. */
		public void push(int x) {
			q.add(x);
			for(int i=0;i<q.size()-1;i++){
				q.add(q.remove());
			}
		}
		
		/** Removes the element on top of the stack and returns that element. */
		public int pop() {
			return q.remove();
		}
		
		/** Get the top element. */
		public int top() {
			return q.peek();
		}
		
		/** Returns whether the stack is empty. */
		public boolean empty() {
			return q.size()==0;
		}
	}
	
	/**
	 * Your MyStack object will be instantiated and called as such:
	 * MyStack obj = new MyStack();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */
}

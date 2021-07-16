package Day14;

import java.util.Stack;

public class MinStack {
	Stack<Integer> st = new Stack<>();
	int min=Integer.MAX_VALUE;
	void push(int x){
		if(st.isEmpty()){
			min = x;
			st.push(x);
			return;
		}
		if(x<min){
			min = x;
			st.push(2*x-min);
		}else{
			st.push(x);
		}
	}
	int pop(){
		if(st.isEmpty()){
			System.out.println("Stack is Empty");
			return Integer.MAX_VALUE;
		}
		int t = st.pop();
		if(t<min){
			int val = min;
			min = 2*min-t;
			return val;
		}else{
			return t;
		}
	}
	int getMin(){
		if(st.isEmpty()){
			System.out.println("Stack is Empty");
			return Integer.MAX_VALUE;
		}
		else{
			return min;
		}
	}
	int peek(){
		if(st.isEmpty()){
			System.out.println("Stack is Empty");
			return Integer.MAX_VALUE;
		}
		int t = st.peek();
		if(t<min){
			return min;
		}else{
			return t;
		}
	}
}

package Day13;

public class StackUsingArray {
	static class Stack{
		int size;
		int[] stack;
		int top;

		Stack(int size){
			this.size = size;
			stack = new int[size];
			top = -1;
		}
		void push(int data){
			if(top==size-1){
				System.out.println("Stack Overflow");
				return;
			}
			stack[++top] = data;
		}
		int pop(){
			if(top==-1){
				System.out.println("Stack Underflow");
				return Integer.MIN_VALUE;
			}
			return stack[top--];
		}
		int top(){
			return stack[top];
		}
		void display(){
			if(top==-1){
				System.out.println("Stack Underflow");
			}
			for(int i=0;i<=top;i++){
				System.out.print(stack[i]+" ");
			}
			System.out.println();
		}
	}
}

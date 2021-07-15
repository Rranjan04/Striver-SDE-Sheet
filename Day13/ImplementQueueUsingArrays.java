package Day13;


public class ImplementQueueUsingArrays {
	static class Queue{
		int size, front, rear,count;
		int[] queue;
		Queue(int size){
			this.size = size;
			front = rear = 0;
			count=0;
			queue = new int[size];
		}
		void enqueue(int data){
			if(count==size){
				System.out.println("Queue is full");
				return;
			}
			queue[rear%size] = data;
			rear++;
			count++;

		}
		int dequeue(){
			if(count==0){
				System.out.println("Queue is Empty");
			}
			int value = queue[front%size];
			queue[front%size] = Integer.MAX_VALUE;
			front++;
			count--;
			return value;
		}
		void display(){
			for(int i=front;i<rear;i++){
				System.out.print(queue[i%size]+" ");
			}
			System.out.println();
		}
	}
}

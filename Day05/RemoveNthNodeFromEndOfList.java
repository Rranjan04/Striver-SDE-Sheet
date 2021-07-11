package Day05;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null) return null;
		 int size = 0;
		 ListNode temp = head;
		 while(temp!=null){
			 temp = temp.next;
			 size++;
		 }
		 if(n==size){
			 return head.next;   
		 }
		 ListNode slow = head , fast = head;
		 while(n>=1){
			 fast = fast.next;
			 n--;
		 }
		 while(fast.next!=null){
			 fast = fast.next;
			 slow = slow.next;
		 }
		 if(slow.next!=null){
			 slow.next = slow.next.next;
		 }
		 return head;
	 }
}

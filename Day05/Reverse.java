package Day05;
class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
		next = null;
	}
}
public class Reverse {
	public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head, next=head;
        while(curr!=null){
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
	public ListNode reverseListRec(ListNode head) {
		if(head==null||head.next==null) return head;
		 ListNode t = reverseList(head.next);
		 head.next.next = head;
		 head.next = null;
		 return t;
	 }
}

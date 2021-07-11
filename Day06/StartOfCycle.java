package Day06;

public class StartOfCycle {
	public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast!=null  && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null || fast.next==null) return null;
        slow= head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

package Day06;

public class Cycle {
	public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast!=null  && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}

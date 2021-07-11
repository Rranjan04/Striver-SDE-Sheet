package Day06;

public class RotateLL {
	public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head; 
        int size = size(head);
        k = k%size;
        if(k==0) return head;
        ListNode fast = head, slow = head, slowH = null,fastH=null;
        while(k>0){
            fastH = fast;
            fast = fast.next;
            k--;
        }
        while(fast!=null){
            fastH = fast;
            fast = fast.next;
            slowH = slow;
            slow = slow.next;
        }
        fastH.next = head;
        head = slow;
        slowH.next = null;
        return head;
        
    }
    public int size(ListNode root){
        int size =0 ;
        while(root!=null){
            root = root.next;
            size++;
        }
        return size;
    }
}

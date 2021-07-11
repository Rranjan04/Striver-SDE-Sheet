package Day06;

public class kReverse {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null||k<=1) return head;
        int len = size(head);
        ListNode oh = null,ot = null;
        ListNode curr = head;
        while(len>=k){
            int tempK = k;
            while(tempK>0){
                ListNode next = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = next;
                tempK--;
            }
            len-=k;
            if(oh==null){
                oh = th;
                ot = tt;
            }else{
                ot.next = th;
                ot = tt;
            }
            th = null;
            tt = null;
        }
        ot.next = curr;
        return oh;
    }
    static ListNode th = null;
    static ListNode tt = null;
    static void addFirst(ListNode node){
        if(th==null){
            th = node;
            tt = th;
        }
        else{
            node.next = th;
            th = node;
        }
    }
    public int size(ListNode node){
        int ans=0;
		while(node!=null){
			ans++;
			node=node.next;
		}
		return ans;
    }
}

package Day06;
class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
		next = null;
	}
}
public class Intersection {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int s1 = getSize(headA);
        int s2 = getSize(headB);
        if(s1>s2){
            return help(headA,headB,s1-s2);
        }else{
            return help(headB,headA,s2-s1);
        }
        
    }
    private ListNode help(ListNode h1, ListNode h2,int dif){
        while(dif>0 && h1!=null){
            h1 = h1.next;
            dif--;
        }
        while(h1!=null && h2!=null && h1!=h2){
            h1 = h1.next;
            h2 = h2.next;
        }
        if(h1==null||h2==null) return null;
        return h1;
    }
    private int getSize(ListNode node){
        int size =0;
        while(node!=null){
            node = node.next;
            size++;
        }
        return size;
    }
}

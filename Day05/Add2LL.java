package Day05;

public class Add2LL {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s1 = size(l1);
        int s2 = size(l2);
        if(s1>s2){   
            return add(l1,l2);
        }
        return add(l2,l1);
        
    } 
    private static int size(ListNode head){
        int size = 0;
        while(head!=null){
            head = head.next;
            size++;
        }
        return size;
    }
    private ListNode add(ListNode l1, ListNode l2){
        ListNode t = l1;
        int carry = 0;
        ListNode prev = l1;
        while(l2!=null){
                int temp = l1.val;
                l1.val = (l1.val+l2.val+carry)%10;
                carry = (temp+l2.val+carry)/10;
                prev = l1;
                l1 = l1.next;
                l2 = l2.next;
            }
            while(l1!=null){
                int temp = l1.val;
                l1.val = (l1.val+carry)%10;
                carry = (temp+carry)/10;
                prev = l1;
                l1 = l1.next;
            }
            if(carry!=0){
                prev.next = new ListNode(carry);
            }
        return t;
    }
}

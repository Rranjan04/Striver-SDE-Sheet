package Day06;

public class Palindrome {
	static ListNode h;
    public boolean isPalindrome(ListNode head) {
        h = head;
        return help(head);
    }
    private boolean help(ListNode node){
        if(node==null) return true;
        if(!help(node.next)) return false;
        int temp = h.val;
        h = h.next;
        return temp==node.val;
    }
}

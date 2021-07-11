package Day07;

import java.util.HashMap;


public class CopyListWithRandomPointer {

	static class Node{
		int val;
		Node next;
		Node random;
		Node(int val){
			this.val = val;
			next = random = null;
		}
	}
	public Node copyBetter(Node head){
		Node temp = head;
		while(temp!=null){
			Node node = new Node(head.val);
			node.next = temp.next;
			temp.next = node;
			temp = temp.next.next;
		}
		temp = head;
		while(temp!=null){
			if(temp.next!=null){
				temp.next.random = temp.random.next;
			}else{
				temp.next.random = null;
			}
			temp = temp.next.next;

		}
		temp = head;
		Node tHead = temp.next , t1 = null;
		while(temp!=null){
			t1 = temp.next;
			temp.next = temp.next.next;
			if(t1.next!=null){
				t1.next = t1.next.next;
			}

			temp = temp.next;
		}
		return tHead;
	}
	public Node copyRandomList(Node head) {
        if(head==null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            Node node = new Node(temp.val);
            map.put(temp,node);
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            Node node = map.get(temp);
            node.next = map.get(temp.next);
            node.random = map.get(temp.random);
            temp =temp.next;
        }
        return map.get(head);
    }
}

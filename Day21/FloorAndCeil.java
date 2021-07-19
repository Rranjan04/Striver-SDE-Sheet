package Day21;
class Node{
	int val;
	Node right,left;
	Node(int val){
		this.val = val;
	}
}
public class FloorAndCeil {
	public Node getSuccessor(Node a, int b) {
        Node next = null;
        while(a!=null){
            if(a.val==b){
                if(a.right!=null){
                    Node t = a.right;
                    while(t.left!=null){
                        t = t.left;
                    }
                    next = t;
                }
                return next;
            }
            else if(a.val>b){
                next = a;
                a = a.left;
            }else{
                a = a.right;
            }
        }
        return next;
    }
}

package Day06;

public class FlattenLL {
	static class Node
	{
		int data;
		Node next;
		Node bottom;
		
		Node(int d)
		{
			data = d;
			next = null;
			bottom = null;
		}
	}
	Node flatten(Node root)
    {
	    if(root==null||root.next==null) return root;
	    root.next = flatten(root.next);
	    root = help(root,root.next);
	    return root;
    }
    Node help(Node n1, Node n2){
        if(n1==null) return n2;
        if(n2==null) return n1;
        if(n1.data<n2.data){
            n1.bottom = help(n1.bottom,n2);
            return n1;
        }
        n2.bottom = help(n1,n2.bottom);
        return n2;
    }
}

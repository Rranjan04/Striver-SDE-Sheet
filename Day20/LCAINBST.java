package Day20;

public class LCAINBST {
	public Node lowestCommonAncestor(Node root, Node p, Node q)     {
        if(root==null) return null;
        if(root.val==p.val||root.val==q.val) return root;
        Node l = lowestCommonAncestor(root.left,p,q);
        Node r = lowestCommonAncestor(root.right,p,q);
        if(l!=null && r!=null) return root;
        if(l!=null) return l;
        return r;
    }
}

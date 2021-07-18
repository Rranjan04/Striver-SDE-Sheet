package Day18;

public class LCA {
	public   Node lowestCommonAncestor(  Node root,   Node p,   Node q) {
        if(root==null) return null;
       if(root.val==p.val||root.val==q.val) return root;
          Node l = lowestCommonAncestor(root.left,p,q);
          Node r = lowestCommonAncestor(root.right,p,q);
        if(l!=null && r!=null) return root;
        else if(l!=null) return l;
        return r;
    }
}

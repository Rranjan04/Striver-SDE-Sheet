package Day18;

public class AreIdentical {
	public boolean isSameTree(  Node p,   Node q) {
        if(p==null && q==null) return true;
        if(p==null|| q==null) return false;
        boolean l = isSameTree(p.left,q.left);
        boolean r = isSameTree(p.right,q.right);
        if(l&&r){
            return p.val==q.val;
        }
        return false;
    }
}

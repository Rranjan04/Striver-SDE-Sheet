package Day18;

public class isBalanced {
	static boolean ans;
    public boolean find(Node root) {
        ans = true;
        height(root);
        return ans;
    }
    private int height(Node root){
        if(root==null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        if(ans){
            ans = Math.abs(l-r)<=1?true:false;
        }
        return Math.max(l,r)+1;
    }
}

package Day20;

public class ValidateBST {
	class Pair{
        boolean isBST;
        long min,max;
        Pair(){
            isBST = true;
            max = Long.MIN_VALUE;
            min = Long.MAX_VALUE;
        }
    }
    public boolean isValidBST(Node root) {
        if(root==null) return true;
        return help(root).isBST;
    }
    public Pair help(Node root){
        if(root==null) return new Pair();
        Pair left = help(root.left);
        Pair right = help(root.right);
        Pair ans = new Pair();
        ans.max = Math.max(root.val,Math.max(left.max,right.max));
        ans.min = Math.min(root.val,Math.min(left.min,right.min));
        ans.isBST = left.isBST&&right.isBST&&((left.max<root.val)&&(right.min>root.val));
        return ans;
    }
}

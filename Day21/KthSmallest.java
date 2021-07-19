package Day21;

public class KthSmallest {
	public int kthSmallest(Node root, int k) {
        int[] a = new int[1];
        a[0] = k;
       return kthSmallestHelp(root,a);
    }
    public int kthSmallestHelp(Node root, int[] k){
         if(root==null) return Integer.MAX_VALUE;
        int left = kthSmallestHelp(root.left,k);
        if(left!=Integer.MAX_VALUE){
            return left;
        }
        k[0]-=1;
        if(k[0]==0){
            return root.val;
        }
        return kthSmallestHelp(root.right,k);
    }
   
}

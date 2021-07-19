package Day21;

public class KthLargest {
	public int kthLargest(Node root, int k) {
        int[] a = new int[1];
        a[0] = k;
       return kthLargestHelp(root,a);
    }
    public int kthLargestHelp(Node root, int[] k){
         if(root==null) return Integer.MAX_VALUE;
        int right = kthLargestHelp(root.right,k);
        if(right!=Integer.MAX_VALUE){
            return right;
        }
        k[0]-=1;
        if(k[0]==0){
            return root.val;
        }
        return kthLargestHelp(root.left,k);
    }
}

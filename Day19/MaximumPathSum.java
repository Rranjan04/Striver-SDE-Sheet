package Day19;
class Node{
	int val;
	Node right;
	Node left;
	Node(int val){
		this.val = val;
	}
}
// DP On Trees->Like kadane's
public class MaximumPathSum {
	static int max = Integer.MIN_VALUE;
	static int help(Node root){
		if(root==null) return 0;
		int l = Math.max(0,help(root.left));
		int r = Math.max(0,help(root.right));
		int sum = Math.max(l, r)+root.val;
		int both = Math.max(l+r+root.val, sum);
		max = Math.max(max, both);
		return sum;
	}
}

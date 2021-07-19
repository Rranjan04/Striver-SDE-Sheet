package Day21;

public class LargestBST {
	static class Info{
		int size;
		int max;
		int min;
		int ans;
		boolean isBST;
		Info(){}
		Info(int size, int max, int min, int ans,boolean isBST){
			this.size = size;
			this.max = max;
			this.min = min;
			this.isBST = isBST;
			this.ans = ans;
		}
	}
	static int MAX = Integer.MAX_VALUE;
	static int MIN = Integer.MIN_VALUE;
	static Info largest(Node root){
		if(root==null) return new Info(0,MIN,MAX,0,true);
		if(root.left==null && root.right==null) return new Info(1,root.val,root.val,1,true);
		Info l = largest(root.left);
		Info r = largest(root.right);
		Info ans = new Info();
		ans.size = 1+l.size+r.size;
		if(l.isBST&&r.isBST&&(l.max<root.val)&&(r.min>root.val)){
			// rooted BST
			ans.min = Math.min(root.val, Math.min(l.min, r.min));
			ans.max = Math.max(root.val, Math.max(r.max, l.max));
			ans.ans = ans.size;
			ans.isBST = true;
			return ans;
		}
		ans.ans = Math.max(l.ans, r.ans);
		ans.isBST = false;
		// start min and max from scratch
		return ans;
	}
}

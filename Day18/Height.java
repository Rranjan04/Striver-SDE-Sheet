package Day18;

public class Height {
	static int find(Node root){
		if(root==null) return 0;
		int l = find(root.left);
		int r = find(root.right);
		return Math.max(l, r)+1;
	}
}

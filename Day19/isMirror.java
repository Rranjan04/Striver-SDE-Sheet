package Day19;

public class isMirror {
	static boolean find(Node root){
		return help(root,root);
	}
	static boolean help(Node r1, Node r2){
		if(r1==null && r2==null) return true;
		if(r2==null||r1==null) return false;
		if(r1.val!=r2.val) return false;
		boolean r = help(r1.right,r2.left);
		boolean l = help(r1.left, r2.right);
		return l&& r;
	}
}

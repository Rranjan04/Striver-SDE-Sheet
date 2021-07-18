package Day19;

public class SymmetricBT {
	public boolean isSymmetric(  Node root) {
		return help(root,root);
	 }
	 public boolean help(  Node r1,   Node r2){
		 if(r1==null && r2==null) return true;
		 if(r1==null||r2==null) return false;
		 if(r1.val!=r2.val) return false;
		 boolean l  = help(r1.left,r2.right);
		 boolean r = help(r1.right,r2.left);
		 return l&&r;
	 }
}

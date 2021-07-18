package Day19;

public class FlattenBT {
	public void flatten(  Node root) {
		flattenHelp(root);
   }
   public   Node flattenHelp(  Node root){
	   if(root==null) return null;
	     Node left = flattenHelp(root.left);
	     Node right = flattenHelp(root.right);
	   root.left = null;
	   root.right = left;
	     Node temp = root;
	   if(temp!=null){
		   while(temp.right!=null){
			   temp = temp.right;
		   }
		   temp.right = right;
	   }
	   return root;
   }
}

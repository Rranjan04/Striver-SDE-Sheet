package Day19;

public class ConstructFromInAndPost {
	public   Node buildTree(int[] inorder, int[] postorder) {
        return help(postorder,inorder,0,postorder.length-1,0,inorder.length-1);
    }
     public   Node help(int[] p, int[] in, int ps, int pe, int is, int ie){
         if(ps>pe||is>ie) return null;
          Node root = new   Node(p[pe]);
         int key = p[pe];
         int i=is;
        for(;i<=ie;i++){
            if(in[i]==key) break;
        }
         root.left = help(p,in,ps,ps+(i-is)-1,is,i-1);
         root.right = help(p,in,ps+(i-is),pe-1,i+1,ie);
         return root;
         
     }
}

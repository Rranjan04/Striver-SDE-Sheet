package Day19;

public class ConstructFromInAndPre {
	public   Node buildTree(int[] pre, int[] in) {
        return help(pre,in,0,pre.length-1,0,in.length-1);
    }
    public   Node help(int[] p, int[] in, int ps, int pe, int is, int ie){
        if(ps>pe||is>ie) return null;
          Node root = new   Node(p[ps]);
        int key = p[ps];
        int i=is;
        for(;i<=ie;i++){
            if(in[i]==key) break;
        }
        root.left = help(p,in,ps+1,ps+(i-is),is,i-1);
        root.right = help(p,in,ps+(i-is)+1,pe,i+1,ie);
        return root;
    }
}

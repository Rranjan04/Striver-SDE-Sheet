package Day21;

public class SerialiseAndDeserialise {
	static String ans ="";
    public String serialize(Node root) {
        help(root);
        System.out.println(ans);
        return ans;
    }
    private void help(Node root){
        if(root==null){
            ans+="*";
            return;
        }
        ans+=root.val+"/";
        help(root.left);
        help(root.right);
        
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
//     4-7**-3-9960*-1**6-4****-7-65***-69-2****-3-4***
       if(i>=data.length()) return null;
        if(data.charAt(i)=='*'){
            i+=1;
            return null;
        }
        Node root;
        String ans = "";
        while(data.charAt(i)!='/'){
            ans+=data.charAt(i);
            i++;
        }
        i++;
        root = new Node(Integer.parseInt(ans));
        root.left = deserialize(data);
        root.right = deserialize(data);
        return root;
    }
    static int i =0;
}

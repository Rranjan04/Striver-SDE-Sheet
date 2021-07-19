package Day22;
class Node{
	int val;
	Node left, right;
	Node(int val){
		this.val = val;
	}
}
public class BTToDLL {
	static Node head;
	static Node prev = null;
	static void convert(Node root){
		// conversion is done inorder
		if(root==null) return;
		convert(root.left);
		if(prev==null){
			head = root;
		}else{
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		convert(root.right);
	}
}

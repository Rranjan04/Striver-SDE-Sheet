package Day20;
class Node{
	int val;
	Node left,right;
	Node(int val){
		this.val = val;
	}
}
public class SearchInBST {
	static boolean isPresent(Node root, int key){
		if(root==null) return false;
		if(root.val==key) return true;
		if(root.val>key){
			return isPresent(root.left, key);
		}else{
			return isPresent(root.right, key);
		}
	}
	static boolean isPresentIterative(Node root, int key){
		while(root!=null){
			if(root.val==key) return true;
			else if(root.val>key){
				root = root.left;
			}else{
				root = root.right;
			}
		}
		return false;
	}
}

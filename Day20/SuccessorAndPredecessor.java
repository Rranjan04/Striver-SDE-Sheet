package Day20;

public class SuccessorAndPredecessor {

	static int pre = Integer.MIN_VALUE;
	static int suc = Integer.MAX_VALUE;
	static void find(Node root, int key){
		if(root==null) return;
		if(root.val==key){
			if(root.left!=null){
				Node t = root.left;
				while(t.right!=null){
					// pre is max value in its left subtree
					t = t.right;
				}
				pre = t.val;
			}
			if(root.right!=null){
				if(root.right!=null){
					// suc is min value in right subtree
					Node t = root.right;
					while(t.left!=null){
						t = t.left;
					}
					suc = t.val;
				}
			}
			return;
		}
		if(root.val>key){
			// key is smaller
			suc = root.val;
			find(root.left, key);
		}else{
			pre = root.val;
			find(root.right, key);
		}

	}
}

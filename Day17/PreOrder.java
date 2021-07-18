package Day17;

import java.util.Stack;

public class PreOrder {
	static void recursive(Node root){
		if(root==null) return;
		System.out.print(root.val+" ");
		recursive(root.left);
		recursive(root.right);
	}
	static void iterative(Node root){
		Stack<Pair> st = new Stack<>();
		st.push(new Pair(root, 0));
		while(!st.isEmpty()){
			Pair p = st.pop();
			if(p.state==0){
				System.out.print(p.node.val+" ");
				if(p.node.left!=null){
					st.push(new Pair(p.node.left, 0));
				}
				p.state++;
			}else if(p.state==1){
				if(p.node.right!=null){
					st.push(new Pair(p.node.right, 0));
				}
				p.state++;
			}else{
				st.pop();
			}
		}
	}
}

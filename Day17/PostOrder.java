package Day17;

import java.util.Stack;

public class PostOrder {
	static void recursive(Node root){
		if(root==null) return;
		recursive(root.left);
		recursive(root.right);
		System.out.print(root.val+" ");
	}
	static void iterative(Node root){
		Stack<Pair> st = new Stack<>();
		st.push(new Pair(root, 0));
		while(!st.isEmpty()){
			Pair p = st.pop();
			if(p.state==0){
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
				System.out.print(p.node.val+" ");
				st.pop();
			}
		}
	}
}

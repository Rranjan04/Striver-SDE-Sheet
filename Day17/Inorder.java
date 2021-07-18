package Day17;

import java.util.Stack;

class Node {
	int val;
	Node right;
	Node left;
	Node(int val){
		this.val = val;
	}
}
class Pair{
	Node node;
	int state;
	Pair(Node node, int state){
		this.node = node;
		this.state = state;
	}
}
public class Inorder{
	static void rec(Node root){
		if(root==null) return;
		rec(root.left);
		System.out.print(root.val+" ");
		rec(root.right);
	}

	static void iterative(Node root){
		Stack<Pair> st = new Stack<>();
		st.push(new Pair(root,0));
		while(!st.isEmpty()){
			Pair p = st.peek();
			if(p.state==0){
				if(p.node.left!=null){
					st.push(new Pair(p.node.left,0));
				}
				p.state++;
			}else if(p.state==1){
				System.out.print(p.node.val+" ");
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

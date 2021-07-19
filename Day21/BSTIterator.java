package Day21;

import java.util.LinkedList;

public class BSTIterator {
	LinkedList<Node> st;
	public BSTIterator(Node root){
		st = new LinkedList<>();
		addAllLeft(root);
	}
	private void addAllLeft(Node node){
		while(node!=null){
			this.st.addFirst(node);
			node = node.left;
		}
	}
	public int next(){
		Node node = st.removeFirst();
		addAllLeft(node.right);//add left of all right
		return node.val;
	}
	public boolean hasNext(){
		return !st.isEmpty();
	}
}

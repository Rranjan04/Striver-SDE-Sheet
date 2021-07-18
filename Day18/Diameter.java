package Day18;

public class Diameter {
	// Various Approach
	// APPROACH 1
	static int diameter(Node root){
		return help(root)[0];
	}
	static int[] help(Node root){
		if(root==null) return new int[]{0,-1};
		int[] left = help(root.left);
		int[] right = help(root.right);
		int dia = Math.max(left[0], Math.max(right[0], left[1]+right[1]+2));
		int height = Math.max(left[1], right[1])+1;
		return new int[]{dia,height};
	}
	// APPROACH 2
	static int max = 0;
	static int calculate(Node root){
		if(root==null) return -1;
		int l = calculate(root.left);
		int r = calculate(root.right);
		max = Math.max(max, l+r+2);
		return Math.max(l, r)+1;
	}
}

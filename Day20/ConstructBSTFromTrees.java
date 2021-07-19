package Day20;

import java.util.Arrays;

public class ConstructBSTFromTrees {
	// from an unsorted array
	public Node sortedArrayToBST(int[] nums) {
		Arrays.sort(nums);
        return help(nums,0,nums.length-1);
    }
    Node help(int[] nums, int low, int high){
        if(low>high) return null;
        int mid = low+(high-low)/2;
        Node root = new Node(nums[mid]);
        root.left = help(nums,low,mid-1);
        root.right = help(nums,mid+1,high);
        return root;
    }
}

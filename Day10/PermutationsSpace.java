package Day10;

import java.util.ArrayList;
import java.util.List;

public class PermutationsSpace {
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		help(0,nums,res);
		return res;
	}
	public void help(int idx, int[] nums, List<List<Integer>> res){
		if(idx==nums.length){
			ArrayList<Integer> ans = new ArrayList<>();
			for(int x:nums){
				ans.add(x);
			}
			res.add(new ArrayList<>(ans));
			return;
		}
		for(int i=idx;i<nums.length;i++){
			swap(nums, i, idx);
			help(idx, nums, res);
			swap(nums, i, idx);
		}
	}
	public void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

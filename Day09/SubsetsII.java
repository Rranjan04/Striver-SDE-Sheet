package Day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public  class SubsetsII {
	public List<List<Integer>> findSubsets(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();
		help(0,nums,new ArrayList<>(),ans);
		return ans;
	}
	public void help(int idx, int[] nums, ArrayList<Integer> ds,List<List<Integer>> ans){
		ans.add(new ArrayList<>(ds));
		for(int i=idx;i<nums.length;i++){
			if(i!=idx && nums[i]==nums[i-1]) continue;
			ds.add(nums[i]);
			help(i+1,nums,ds,ans);
			ds.remove(nums[i]);
		}
	}
}

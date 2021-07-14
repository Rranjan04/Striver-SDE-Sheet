package Day10;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> help = new ArrayList<>();
        for(int x:nums){
            help.add(x);
        }
        fill(res,new ArrayList<>(), help);
        return res;
    }
    public void fill(List<List<Integer>> res, List<Integer> ans,ArrayList<Integer> nums){
        if(nums.size()==0){
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        for(int i=0;i<nums.size();i++){
            Integer t = nums.get(i);
            ans.add(t);
            nums.remove(i);
            fill(res,ans,nums);
            nums.add(i,t);
            ans.remove(ans.size()-1);
        }
    }
}

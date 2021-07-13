package Day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        help(0,target,candidates,res,new ArrayList<>());
        return res;
    }
    public void help(int idx, int target, int[] arr,List<List<Integer>> res , ArrayList<Integer> ans){
        if(target==0){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(i!=idx && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            else{
                ans.add(arr[i]);
                help(i+1,target-arr[i],arr,res,ans);
                ans.remove(ans.size()-1);
            }
        }
    }
}

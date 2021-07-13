package Day09;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
	public List<List<Integer>> combinationSum(int[] candidates, int target)     {
        List<List<Integer>> res = new ArrayList<>();
        help(0,target,candidates,res,new ArrayList<>());
        return res;
        
    }
    public void help(int idx, int target, int[] arr,List<List<Integer>> res , ArrayList<Integer> ans){
        if(idx>=arr.length) return;
        if(target==0){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(target<arr[idx]){
            help(idx+1,target,arr,res,ans);
        }else{
            help(idx+1,target,arr,res,ans);
            ans.add(arr[idx]);
            help(idx,target-arr[idx],arr,res,ans);
            ans.remove(ans.size()-1);
        }
    }
}

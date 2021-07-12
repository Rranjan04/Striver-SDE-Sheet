package Day09;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum {
	static boolean find(int[] set, int target, int n){
		if(n==0) return false;
		if(target==0) return true;
		if(set[n-1]>target) return find(set, target, n-1);
		return find(set, target, n-1)||find(set, target-set[n-1], n-1);
	}
	//return all possible subset sum
	static ArrayList<Integer> subsetSum(ArrayList<Integer> arr, int n){
		ArrayList<Integer> res = new ArrayList<>();
		help(arr,res,0,0);
		Collections.sort(res);
		return res;
	}
	static void help(ArrayList<Integer> arr, ArrayList<Integer> res, int idx, int sum){
		if(idx==arr.size()){
			res.add(sum);
			return;
		}
		help(arr, res, idx+1, sum);
		help(arr, res, idx+1, sum+arr.get(idx));
	}
}

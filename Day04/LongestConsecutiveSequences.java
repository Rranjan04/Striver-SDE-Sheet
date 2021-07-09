package Day04;

import java.util.HashMap;

public class LongestConsecutiveSequences {
	public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> set = new HashMap<>();
        for(int x:nums){
            set.put(x,true);
        }
        for(int i=0;i<set.size();i++){
            if(set.containsKey(nums[i]-1)){
                set.put(nums[i],false);
            }
        }
        int maxLen = 0;
        for(int val:nums){
            if(set.get(val)){
                int tl =  1;
                int tsp = val;
                while(set.containsKey(tsp+tl)){
                    tl++;
                }
                maxLen = Math.max(maxLen,tl);
            }
        }
        return maxLen;
    }
}

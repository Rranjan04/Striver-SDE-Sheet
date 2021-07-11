package Day04;

import java.util.HashMap;

public class LargestSubArrayWithZeroSum {
	int maxLen(int arr[], int n)
    {
        HashMap<Integer,Integer> set = new HashMap<>();
        set.put(0,-1);
        int maxLen = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
             sum+= arr[i];
            if(!set.containsKey(sum)){
                set.put(sum,i);
            }
            else{
                maxLen = Math.max(maxLen,i-set.get(sum));
            }
        }
        return maxLen;
    }
}

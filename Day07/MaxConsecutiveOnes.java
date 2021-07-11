package Day07;

public class MaxConsecutiveOnes {
	// 2 pointer
	public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0, r=0;
        int max = 0;
        while(r<nums.length){
           if(nums[r]==1){
               if(nums[l]==0) l=r;
               max =Math.max(max,r-l+1);
           }else{
               l = r;
           }
            r++;
        }
        return max;
    }
	public int findMaxConsecutiveOnesII(int[] nums) {
        int o =0, max = 0;
        for(int x:nums){
            if(x==1){
                o++;
                max = Math.max(o,max);
            }else{
                o =0;
            }
        }
        return max;
    }
}

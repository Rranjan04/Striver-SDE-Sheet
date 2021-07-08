package Day03;

public class MajorityElement {
	public int majorityElementI(int[] nums) {
        int count =1, id = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[id]){
                count++;
            }else{
                count--;
            }
            if(count==0){
                id = i;
                count = 1;
            }
        }
        count=0;
		for(int i=0;i<nums.length;i++){
			if(nums[id]==nums[i]) count++;
		}
		return count>nums.length/2?nums[id]:-1;
        
    }
}

package Day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	public static void main(String[] args) {
		
	}
	public List<List<Integer>> threeSum(int[] arr) {
        if(arr.length<3){
            new ArrayList<>();
        }
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++){
            int j = i+1;
            int k = arr.length-1;
            while(j<k){
                if(arr[j]+arr[k]== -arr[i]){
                    set.add(Arrays.asList(arr[i],arr[j++],arr[k--]));
                }else if (arr[j]+arr[k]>-arr[i]){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return new ArrayList(set);
        
    }
	
}

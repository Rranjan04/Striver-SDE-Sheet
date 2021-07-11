package Day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] arr) {
        if(arr.length<3){
            new ArrayList<>();
        }
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        int i=0;
        for(;i<n;i++){
            int target = -arr[i];
            int l = i+1, r= n-1;
            while(l<r){
                int sum = arr[l]+arr[r];
                 if(sum<target){
                   l++;
                }
                else if (sum>target){
                   r--;
                }
                else{
                    List<Integer> ans = new ArrayList<>();
                    ans.add(arr[i]);
                    ans.add(arr[l]);
                    ans.add(arr[r]);
                    list.add(ans);
                    while(l<r && arr[l]==ans.get(1))++l;
                    while(l<r && arr[r]==ans.get(2))--r;
                }
            }
            while(i+1<n && arr[i]==arr[i+1])++i;
        }
        return list;
        
    }
    
}

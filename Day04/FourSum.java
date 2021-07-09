package Day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] arr, int target) {
		List<List<Integer>> res = new ArrayList<>();
		  Arrays.sort(arr);
		  int n = arr.length;
		  for(int i=0;i<n;i++){
			  for(int j=i+1;j<n;j++){
				  int t2 = target-arr[i]-arr[j];
				  int f = j+1;
				  int b = n-1;
				  while(f<b){
					  int ts = arr[f]+arr[b];
					  if(ts<t2) f++;
					  else if(ts>t2) b--;
					  else{
						  List<Integer> ans = new ArrayList<>();
						  ans.add(arr[i]);
						  ans.add(arr[j]);
						  ans.add(arr[f]);
						  ans.add(arr[b]);
						  res.add(ans);
						  while(f<b && arr[f]==ans.get(2)) ++f;
						  while(f<b && arr[b]==ans.get(3)) --b;
					  }
				  }
				  while(j+1<n && arr[j+1]==arr[j])++j;
			  }
			  while(i+1<n && arr[i+1]==arr[i])++i;
		  }
		  return res;
	  }
}

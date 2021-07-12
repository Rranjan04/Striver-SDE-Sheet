package Day08;

import java.util.Arrays;

public class MinimumPlatforms {
	static int find(int[] arr, int[] dep, int n){
		Arrays.sort(arr);
		Arrays.sort(dep);
		int max = 1;
		int p = 1;
		int i=1;
		int j=0;
		while(i<n && j<n){
			if(dep[j]<=arr[i]){
				p++;
				i++;
			}else{
				p--;
				j++;
			}
			if(p>max){
				max = p;
			}
		}
		return max;
	}
}

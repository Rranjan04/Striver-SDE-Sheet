package Day03;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	static List<Integer> find(int[] arr){
		int e1 =0 ,e2 =1,c1 =0,c2=0;
		for(int n:arr){
			if(n==e1){
				c1++;
			}else if(n==e2){
				c2++;
			}else if(c1==0){
				e1=n;
				c2 = 1;
			}else if(c2==0){
				e2 = n;
				c2=1;
			}else{
				c1--;
				c2--;
			}
		}
		c1=0;
		c2=0;
		for(int n:arr){
			if(n==e1){
				c1++;
			}else if(n==e2){
				c2++;
			}
		}
		List<Integer> ans = new ArrayList<>();
		if(c1>arr.length/3){
			ans.add(e1);
		}
		if(c2>arr.length/3){
			ans.add(e2);
		}
		return ans;
	}
}

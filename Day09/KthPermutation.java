package Day09;

import java.util.ArrayList;

public class KthPermutation {
	public String find(int n, int k){
		ArrayList<Integer> arr = new ArrayList<>();
		int fact = 1;
		for(int i=1;i<n;i++){
			fact*=i;
			arr.add(i);
		}
		arr.add(n);
		String ans = "";
		k = k-1;// 0 based indexing
		while(true){
			ans+= arr.get(k/fact)+"";
			arr.remove(k/fact);
			if(arr.size()==0) break;
			k = k%fact;
			fact = fact/arr.size();
		}
		return ans;
	}
}

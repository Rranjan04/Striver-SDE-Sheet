package Day12;

import java.util.ArrayList;

public class PowerSet {
	static ArrayList<String> generate(String s){
		int n = s.length();
		ArrayList<String> ans = new ArrayList<>();
		for(int num = 0;num<=(1<<n)-1;num++){
			// num<2^n-1
			String sub ="";
			for(int i=0;i<n;i++){
				if((num & (1<<i))==1){
					// checking set bit
					sub+=s.charAt(i);
				}
			}
			ans.add(sub);
		}
		return ans;
	}
}

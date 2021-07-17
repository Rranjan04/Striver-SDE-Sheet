package Day15;

public class LongestPalindrome {
	public static int  find(String str) {
		// Frequency:
			// Even 
			// Even+Odd(only one)
			int[] lc = new int[26];
			int[] uc = new int[26];
			for(int i=0;i<str.length();i++){
				char c = str.charAt(i);
				if(c-'a'>=0){
					lc[c-'a']++;
				}else{
					uc[c-'A']++;
				}
			}
			int ans = 0;
			boolean flag =false;
			for(int i=0;i<26;i++){
				if(lc[i]%2==0){
					ans+=lc[i];
				}else{
					if(!flag){
						ans+=lc[i];
						flag = true;
					}else{
						ans+=lc[i]-1;
					}
				}
			}
			for(int i=0;i<26;i++){
				if(uc[i]%2==0){
					ans+=uc[i];
				}else{
					if(!flag){
						ans+=uc[i];
						flag = true;
					}else{
						ans+=uc[i]-1;
					}
				}
			}
			return ans;
	}
}

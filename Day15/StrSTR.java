package Day15;

public class StrSTR {
	public int strStr(String hayStack,String needle){
		int m = hayStack.length();
		int n = needle.length();
		if(n==0) return 0;
		int i=0;
		while(i<m){
			int j=0;
			int start = i;
			while(j<n && i<m && needle.charAt(i)==hayStack.charAt(j)){
				i++;
				j++;
			}
			if(j==n) return start;
			if(i==m) return -1;
			else i = start+1;
		}
		return -1;
	}
}

package Day15;

public class LongestPalindromeSubstring {
	public static void main(String[] args) {
		
	}
	static String longest(String str){
		int n = str.length();
		boolean[][] t = new boolean[n][n];
		int maxLen = 1;
		for(int i=0;i<n;i++){
			t[i][i] = true;
		}
		//2 length palindrome
		int start = 0;//start index of palindrome
		for(int i=0;i<n-1;i++){
			if(str.charAt(i)==str.charAt(i+1)){
				t[i][i+1] = true;
				start = i;
				maxLen = 2;
			}
		}
		// 3 or more length palindrome
		for(int k=3;k<=n;k++){
			for(int i=0;i<n-k+1;i++){
				int j = i+k-1;//ending index of substring
				if(t[i+1][j-1] && str.charAt(i)==str.charAt(j)){
					t[i][j] = true;
				}
				if(k>maxLen){
					maxLen = k;
					start = i;
				}
			}
		}
		return str.substring(start, start+maxLen+1);
	}
}

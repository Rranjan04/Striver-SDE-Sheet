package Day16;


public class MinCharsToMakePalindrome {
	public static void main(String[] args) {
		System.out.println(find("AACECAAAA"));
	}
	static int find(String str){
		StringBuilder s2 = new StringBuilder();
		s2.append(str);
		s2.reverse();
		str+=s2;
		int M = str.length();
		int[] lps = new int[M];
		lps[0] = 0;
		int i =1;
		int len = 0;
		while(i<M){
			if(str.charAt(i)==str.charAt(len)){
				len++;
				lps[i] = len;
				i++;
			}else{
				if(len!=0){
					len = lps[len-1];
				}else{
					lps[i] = len;
					i++;
				}
			}
		}
		for(int x:lps){
			System.out.print(x+" ");
		}
		System.out.println();
		return M/2-lps[M-1];
	}
}

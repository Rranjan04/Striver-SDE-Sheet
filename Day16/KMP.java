package Day16;

public class KMP {
	void KMPSearch(String pat, String txt){
		int M = pat.length();
		int N = txt.length();
		int[] lps = new int[M];
		fillArray(pat, lps, M);
		int j = 0;
		int i = 1;
		while(i<N){
			if(pat.charAt(j)==txt.charAt(i)){
				i++;
				j++;
			}
			if(j==M){
				System.out.println("Found pattern at index "+(i-j));
				j = lps[j-1];
			}
			else if(i<N && pat.charAt(j)!=txt.charAt(i)){
				if(j!=0) j = lps[j-1];//find similar pattern
				else i = i+1;// move onto next
			}
		}
	}
	void fillArray(String str,int[] arr,int M){
		int len =0;
		int i=1;
		arr[0] = 0;
		while(i<M){
			if(str.charAt(i)==str.charAt(len)){
				len++;
				arr[i] = len;
				i++;
			}else{
				if(len!=0){
					// backtrack
					// https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
					len = arr[len-1];
				}else{
					arr[i] = len;
					i++;
				}
			}
		}
	}
}

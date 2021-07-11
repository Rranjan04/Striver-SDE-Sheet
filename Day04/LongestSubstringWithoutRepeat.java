package Day04;

import java.util.Arrays;
import java.util.HashSet;

public class LongestSubstringWithoutRepeat {
	public static void main(String[] args) {
		
	}
	public int lengthOfLongestSubstring1(String s) {
		// Sliding Window
		// Worst : O(2*n)
        HashSet<Character> set = new HashSet<>();
        int l = 0, r=0;
        int count =0 ;
        while(r<s.length()){
            char ch = s.charAt(r);
            if(set.contains(ch)){
                while(s.charAt(l)!=ch){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.remove(s.charAt(l));
                l++;
            }
            set.add(ch);
            count = Math.max(count,set.size());
            r++;
        }
        return count;
    }
	public int lengthOfLongestSubstringII(String s) {
        if(s.length()==1||s.length()==0) return s.length();
        int[] arr = new int[256];
        Arrays.fill(arr,-1);
        int r =0,l=0;
        int count =0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(arr[ch]!=-1){
                l = Math.max(l,arr[ch]+1);
            }
            arr[ch] = r;
            count = Math.max(r-l+1,count);
            r++;
        }
        return count;
    }
}

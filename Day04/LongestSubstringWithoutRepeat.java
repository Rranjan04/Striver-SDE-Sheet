package Day04;

import java.util.HashSet;

public class LongestSubstringWithoutRepeat {
	public static void main(String[] args) {
		
	}
	public int lengthOfLongestSubstring1(String s) {
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
}

package Day09;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> find(String s){
		List<List<String>> list = new ArrayList<>();
		help(0,s,new ArrayList<>(),list);
		return list;
	}
	public void help(int idx, String s, ArrayList<String> ans, List<List<String>> list){
		if(idx == s.length()){
			list.add(new ArrayList<>(ans));
		}
		for(int i=idx;i<s.length();i++){
			if(isPalindrome(s, idx, i)){
				ans.add(s.substring(idx, i+1));
				help(i+1, s, ans, list);
				ans.remove(ans.size()-1);
			}
		}
	}
	public boolean isPalindrome(String s, int start, int end){
		while(start<end){
			if(s.charAt(start)!=s.charAt(end)) return false;
			end--;
			start++;
		}
		return true;
	}
}

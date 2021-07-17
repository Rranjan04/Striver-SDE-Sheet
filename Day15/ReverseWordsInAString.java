package Day15;

import java.util.Stack;

public class ReverseWordsInAString {
	public static void main(String[] args) {
		// System.out.println(reverse("i like this program very much"));
	}
	public String reverseWords(String s) {
		String[] str = s.trim().split("\\s+");
		 String ans = "";
		 for(int i=str.length-1;i>=0;i--){
			 ans+=str[i]+" ";
		 }
		 return ans.trim();
	 }
	 public String reverse(String s){
		Stack<String> st = new Stack<>();
		String temp = "";
		String ans = "";
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==' '){
			   if(temp.length()>0){
				   st.push(temp);
				   temp= "";
			   }
			}else{
				temp+=s.charAt(i);
			}
		}
	   ans = ans+ temp;
		while(!st.isEmpty()){
			ans= ans + " "+st.pop();
		}
	   if(ans.length()!=0 && ans.charAt(0)==' '){
//             remove empty space
		   return ans.substring(1);
	   }
		return ans;
	 }
}

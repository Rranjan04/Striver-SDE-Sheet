package Day13;

import java.util.Stack;

public class BalancedParentheses {
	public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                st.push(ch);
            }else if(ch==')'){
                if(!help(st,'(')) return false;
            }else if(ch=='}'){
                if(!help(st,'{')) return false;
            }else{
                if(!help(st,'[')) return false;
            }
        }
        return st.isEmpty();
    }
    public boolean help(Stack<Character> st, char key){
        if(st.isEmpty()) return false;
        if(st.peek()!=key) return false;
        st.pop();
        return true;
    }
}

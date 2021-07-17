package Day16;

public class CountAndSay {
	public String countAndSay(int n) {
        if(n==1) return "1";
        String str = countAndSay(n-1);
        String ans = "";
        int count = 1,i=0;
        while(i<str.length()){
            char ch = str.charAt(i++);
            while(i<str.length() && str.charAt(i)==ch){
                i++;
                count++;
            }
            ans+=count+""+ch;
            count = 1;
        }
        return ans;
    }
}

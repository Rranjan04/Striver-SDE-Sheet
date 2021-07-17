package Day15;

public class ATOI {
	public static void main(String[] args) {
		System.out.println(myAtoi("-123"));
	}
	static int myAtoi(String str){
		boolean sign = str.charAt(0)=='-'?true:false;
		if(sign){
			str = str.substring(1);
		}
		int ans = 0;
		for(int i=0;i<str.length();i++){
			ans = ans*10+(str.charAt(i)-'0');
		}
		return ans;
	}
}

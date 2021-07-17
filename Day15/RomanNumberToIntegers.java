package Day15;

public class RomanNumberToIntegers {
	public static void main(String[] args) {
		
	}
	static int map(char r){
		if(r=='I') return 1;
		if(r=='V') return 5;
		if(r=='X') return 10;
		if(r=='L') return 50;
		if(r=='C') return 100;
		if(r=='D') return 500;
		if(r=='M') return 1000;
		return -1;
	}
	static int romanToDecimal(String str){
		int res = 0;
		for(int i=0;i<str.length();i++){
			int s1 = map(str.charAt(i));
			if(i+1<str.length()){
				int s2 = map(str.charAt(i+1));
				if(s1>=s2){
					res+=s1;
				}else{
					res+=s2-s1;
					i++;
				}
			}
			else{
				res+= s1;
			}
		}
		return res;
	} 
}

package Day15;

public class IntegersToRomanNumbers {
	static String intToRoman(int num){
		String[] m = {"","M","MM","MMM"};
		String[] c = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String[] x = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String[] i = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
		// Converting
		String ans = m[num/1000];
		ans+= c[(num%1000)/100];
		ans+= x[(num%100)/10];
		ans+= i[(num%10)];
		return ans;
	}
}

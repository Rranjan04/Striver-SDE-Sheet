package Day15;

public class LCP {
	static String help(String str1, String str2){
		String res = "";
		int n1 = str1.length();
		int n2 = str2.length();
		for(int i=0,j=0;i<=n1&&j<=n2;i++,j++){
			if(str1.charAt(i)!=str2.charAt(j)){
				break;
			}
			res+= str1.charAt(i);
		}
		return res;
	}
	static String commonPrefix(String[] arr, int n){
		String prefix = arr[0];
		for(int i=1;i<=n-1;i++){
			prefix = help(prefix, arr[i]);
		}
		return prefix;
	}
}

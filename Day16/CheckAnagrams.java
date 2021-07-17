package Day16;

public class CheckAnagrams {
	public static void main(String[] args) {
		
	}
	static boolean isAnagram(String str1, String str2){
		if(str1.length()!=str2.length()) return false;
		int[] arr = new int[256];
		for(int i=0;i<str1.length();i++){
			arr[str1.charAt(i)]++;
		}
		for(int i=0;i<str2.length();i++){
			arr[str2.charAt(i)]--;
		}
		for(int i=0;i<256;i++){
			if(arr[i]!=0) return false;
		}
		return true;
	}
}

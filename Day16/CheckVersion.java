package Day16;

public class CheckVersion {
	public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.",0);
        String[] v2 = version2.split("\\.",0);
        int i=0;
        while(i<v1.length && i<v2.length){
            String s1 = removeZeroes(v1[i]);
            String s2 = removeZeroes(v2[i]);
            if(Integer.valueOf(s1)>Integer.valueOf(s2)){
                return 1;
            }else if(Integer.valueOf(s1)<Integer.valueOf(s2)){
                return -1;
            }
            i++;
        }
        while(i<v1.length){
            String s1=removeZeroes(v1[i]);
            i++;
            if(Integer.valueOf(s1)==0) continue;
            return (Integer.valueOf(s1) > 0) ? 1: -1;
        }
        while(i<v2.length){
            String s1=removeZeroes(v2[i]);
            i++;
            if(Integer.valueOf(s1)==0) continue;
            return (Integer.valueOf(s1)>0) ? -1: 1;
        }
        return 0;
    }
    private String removeZeroes(String str){
        int i=0;
        while(i<str.length() && str.charAt(i)=='0') i++;
        return i==str.length()?"0":str.substring(i);
    }
}

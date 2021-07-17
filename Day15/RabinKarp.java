package Day15;

public class RabinKarp {
	static void search(String pat, String txt, int q){
		//q -> a prime number
		int m = pat.length();
		int n = txt.length();
		int i,j;
		int p =0;//hash value for pattern
		int t=0;//hash value for txt
		int h =1;
		int d = 256;// no of chars
		//value of hash 
		for( i=0;i<m-1;i++){
			h = (h*d)%q;
		}
		for(i=0;i<m;i++){
			p = (d*p+pat.charAt(i))%q;
			t = (d*p+txt.charAt(i))%q;
		}
		for(i=0;i<=n-m;i++){
			if(p==t){
				for(j=0;j<m;j++){
					if(txt.charAt(i+j)!=pat.charAt(j)){
						break;
					}
				}
				if(j==m){
					System.out.println("Pattern found starting at  "+(i+1));
				}
				if(i<n-m){
					t = (d*(t-txt.charAt(i)*h)+txt.charAt(i+m))%q;
					if(t<0){
						t+= q;
					}
				}
			}
		}

	}
}

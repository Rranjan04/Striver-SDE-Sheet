package Day11;

public class NthRootOfANumber {
	public static void main(String[] args) {
		findN(4, 15);
	}
	static double findN(int n, int m){
		// O(n*log(10^5*m))
		double low = 1;
		double high = m;
		double eps = 1e-6;
		while(high-low>eps){
			double mid = (low+high)/2.0;
			if(Math.pow(mid, n)<m){
				low = mid;
			}else{
				high = mid;
			}
		}
		System.out.printf("%.5f\n",low);
		System.out.printf("%.5f",high);
		return low;
	}
}

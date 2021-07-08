package Day03;

public class Power {
	public double myPow(double x, long n) {
		if(n<0){
			return help(1/x,-n);
		} 
		 return help(x,n);
	 }
	 private double help(double x, long n){
		 if(n==0) return 1;
		 if(n==1) return x;
		 double t = myPow(x,n/2);
		 if(n%2==0){
			 return t*t;
		 }else{
			 return t*t*x;
		 }
	 }
}

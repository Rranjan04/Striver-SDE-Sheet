package Day12;

public class DivideInteger {
	// https://leetcode.com/problems/divide-two-integers/discuss/1286238/0ms-Java-Solution-complies-to-all-conditions
	public int divide(int dividend, int divisor){
			if(divisor==0) return Integer.MAX_VALUE;
			if(divisor==-1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
			boolean isPositive = true;
			if((divisor<0)^(dividend<0)){
				isPositive = false;
			}
			long d1 = Math.abs((long)dividend);
			long d2 = Math.abs((long)divisor);
		
			int ans =0;
			while(d1>=d2){
				int shifts=0;
				while(d1>=(d2<<shifts)){
					shifts++;
				}
				ans+=(1<<(shifts-1));
				d1 -= (d2<<(shifts-1));
			}
			if(isPositive) return ans;
			return -ans;
		}
}


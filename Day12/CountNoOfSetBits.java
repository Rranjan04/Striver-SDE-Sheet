package Day12;

public class CountNoOfSetBits {
	// kernighan's Algorithm
	static int count(int n){
		int count =0;
		while(n>0){
			n &=(n-1);//unset the rightmost set bit
			count++;
		}
		return count;
	}
}

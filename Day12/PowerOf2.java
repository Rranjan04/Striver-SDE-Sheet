package Day12;

public class PowerOf2 {
	// Approach1
	static boolean isIt(int num){
		// return Integer when a log on base 2 is taken
		if(num==0) return false;
		return (int)(Math.ceil(Math.log(num)/Math.log(2)))==(int)(Math.floor(Math.log(num)/Math.log(2)));
	}

}

package Day08;

import java.util.ArrayList;

public class MinimumCoins {
	static int deno[] = {1, 2, 5, 10, 20,
		50, 100, 500, 1000};
		static int n = deno.length;
	public int min(int target){
		int count =0;
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=n-1;i>=0;i--){
			while(target-deno[i]>=0){
				target-=deno[i];
				arr.add(deno[i]);
				count++;
			}
		}
		for(int x:arr){
			System.out.print(x+" ");
		}
		return count;
	}
}

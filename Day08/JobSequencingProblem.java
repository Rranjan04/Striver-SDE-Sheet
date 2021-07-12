package Day08;

import java.util.Arrays;

public class JobSequencingProblem {
	public static void main(String[] args) {
		
	}
	static class Jobs{
		int id;
		int dead;
		int profit;
	}
	static public int profit(Jobs[] arr, int n){
		Arrays.sort(arr,(a,b)->(b.profit-a.profit));
		int max = 0;
		for(int i=0;i<n;i++){
			if(arr[i].dead>max){
				max = arr[i].dead;
			}
		}
		int[] res = new int[max+1];
		int count = 0;
		int profit =0;
		Arrays.fill(res, -1);
		for(int i=0;i<arr.length;i++){
			if(res[arr[i].dead]!=-1){
				for(int j=arr[i].dead;j>0;j--){
					if(res[i]==-1){
						res[j] = arr[i].id;
						count++;
						profit += arr[i].profit;
						break;
					}
				}
			}else{
				//freeslot
				res[arr[i].dead] = arr[i].id;
				count++;
				profit+=arr[i].profit;
			}
		}
		System.out.println(profit);
		System.out.println(count);
		return profit;
	}
}

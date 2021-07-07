package Day01;

public class KadanesAlgorithm {
	public static void main(String[] args) {
		
	}
	static int kadanes(int[] arr){
		int sum = 0 , maxSoFar = Integer.MIN_VALUE;
		for(int x:arr){
			sum+=x;
			if(sum<x){
				sum = x;
			}
			if(sum>maxSoFar){
				maxSoFar = sum;
			}
		}
		return maxSoFar;
	}
	static int kadanesAndIndex(int[] arr){
		int sum = 0, maxSoFar = Integer.MIN_VALUE;
		int end = 0, start =0 ,s=0;
		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
			if(maxSoFar<sum){
				maxSoFar = sum;
				start = s;
				end = i;
			}
			if(sum<arr[i]){
				sum = arr[i];
				s = i;
			}
		}
		System.out.println(start);
		System.out.println(end);
		return maxSoFar;
	}
}

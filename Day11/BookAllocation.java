package Day11;

import java.util.ArrayList;

public class BookAllocation {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(12);
		arr.add(34);
		arr.add(67);
		arr.add(90);
		System.out.println(books(arr, 2));
	}
	static int books(ArrayList<Integer> A, int B) {
        if(B>A.size()) return -1;
        int sum = 0;
        int max =0;
        for(int x:A){
            sum+=x;
            max = Math.max(max,x);
        }
        int low = max, high = sum;
        int ans =-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isValid(mid,B,A)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    static boolean isValid(int mid, int s, ArrayList<Integer> arr){
        int count =1;
        int idx=0;
        int sum =0;
        while(idx<arr.size()){
            sum+=arr.get(idx);
            if(sum>mid){
                count++;
                sum =0;
            }else{
                idx++;
            }
        }
        return s>=count;
    }
}

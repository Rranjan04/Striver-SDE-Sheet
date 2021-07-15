package Day11;

public class KthElementOf2SortedArrays {
	public static void main(String[] args) {
		int[] arr1 = {7,12,14,15};
		int[] arr2 = {1,2,3,4,9,11};
		System.out.println(find(arr1, arr2, 9));
 	}
	static int find(int[] arr1, int[] arr2,int k){
		if(arr2.length<arr1.length){
			return find(arr2, arr1,k);
		}
		int n1 = arr1.length;
		int n2 = arr2.length;
		//low: Minimum elements: 0 from 1st array, means k from 2nd array, if k>n2, still elements left=> k-n2 from 1st array 
		// high: if k is smaller than n, no need to pick all n elements
		int low = Math.max(0, k-n2), high =Math.min(k, n1);
		while(low<=high){
			int cut1 = (low+high)/2;
			int cut2 = k- cut1;
			int left1 = cut1==0?Integer.MIN_VALUE:arr1[cut1-1];
			int left2 = cut2==0?Integer.MIN_VALUE:arr2[cut2-1];
			int right1 = cut1==n1?Integer.MAX_VALUE:arr1[cut1];
			int right2 = cut2==n2?Integer.MAX_VALUE:arr2[cut2];
			if(left1<=right2 && left2<=right1){
				return Math.max(left1, left2);
			}else if(left1>right2){
				high = cut1-1;
			}else{
				low = cut1+1;
			}
		}
		return -1;
	}
}

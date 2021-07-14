package Day11;

public class MedianOfRowWiseSortedMatrix {
	//find smaller
	public static void main(String[] args) {
		int[][] m = {{1,2,3},{1,2,4},{4,4,5}};
		System.out.println(findMedian(m));
	}
	static int findSmaller(int[] m,int n){
		int l=0,h=m.length-1;
		while(l<=h){
			int mid = l+(h-l)/2;
			if(m[mid]<=n){
				l = mid+1;
			}else{
				h = mid-1;
			}
		}
		return l;
	}
	static int findMedian(int[][]a){
		int low = 1;
		int high = 10;
		int n = a.length;
		int m = a[0].length;
		while(low<=high){
			int mid = low+(high-low)/2;
			int cnt =0;
			for(int[] x:a){
				cnt+=findSmaller(x, mid);
			}
			if(cnt<=(n*m)/2) {
				low = mid+1;
			}
			else high = mid-1;
		}
		return low;
	}
}

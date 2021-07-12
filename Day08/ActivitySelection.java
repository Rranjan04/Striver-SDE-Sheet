package Day08;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
	class Pair{
		int start,finish;
		Pair(int start, int finish){
			this.start = start;
			this.finish = finish;
		}
	}
	class Help implements Comparator<Pair>{
		public int compare(Pair p1, Pair p2){
			return p1.finish-p2.finish;
		}
	}
	int find(Pair[] arr, int n){
		Arrays.sort(arr);
		int count = 1;
		int end = arr[0].finish;
		for(int i=1;i<n;i++){
			if(arr[i].start>end){
				end = arr[i].finish;
				count++;
			}
		}
		return count;
	}
}

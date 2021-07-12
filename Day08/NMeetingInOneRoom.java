package Day08;

import java.util.Arrays;

public class NMeetingInOneRoom {
	static class Pair implements Comparable<Pair>{
        int start;
        int end;
        Pair(int start , int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Pair p){
            return this.end - p.end;
        }
    }
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        Pair[] arr = new Pair[n];
        for(int i=0;i<n;i++){
            arr[i] = new Pair(start[i],end[i]);
        }
        Arrays.sort(arr);
        int count = 1;
        int e = arr[0].end;
        for(int i=1;i<n;i++){
            if(arr[i].start>e){
                e = arr[i].end;
                count++;
            }
        }
        return count;
    }
}

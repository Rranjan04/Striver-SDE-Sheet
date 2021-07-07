package Day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverlappingSubIntervals {
	static class Time{
		int start;
		int end;
		Time(int start, int end){
			this.start = start;
			this.end = end;
		}
		
	}
	static ArrayList<Time> merge(ArrayList<Time> intervals){
		Stack<Time> st = new Stack<>();
		Collections.sort(intervals,new Comparator<Time>(){
			public int compare(Time t1, Time t2){
				return t1.start- t2.start;
			}
		});
		st.push(intervals.get(0));
		for(int i=1;i<intervals.size();i++){
			Time curr = st.peek();
			if(curr.end<intervals.get(i).start){
				st.push(intervals.get(i));
				continue;
			}
			else if(curr.end>=intervals.get(i).start){
				curr.end = Math.max(curr.end, intervals.get(i).end);
			}
		}
		ArrayList<Time> ans = new ArrayList<>();
		while(!st.isEmpty()){
			ans.add(st.pop());
		}
		return ans;
	}
}

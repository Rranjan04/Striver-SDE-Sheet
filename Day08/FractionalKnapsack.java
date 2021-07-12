package Day08;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
	class Item{
		int weight;
		int value;
	}
	// class Help implements Comparator<Item>{
	// 	public int compare(Item a,Item b){
	// 		double r1 = (double)(a.value)/(double)(a.weight);
	// 		double r2 = (double)(b.value)/(double)(b.weight);
	// 		return (int)(r1-r2);
	// 	}
	// }
	double knapsack(int w, Item[] arr, int n){
		Arrays.sort(arr,(a,b)->((a.value)/a.weight)-(b.value)/(b.weight));
		int weight = 0;
		double profit = 0;
		for(int i=0;i<n;i++){
			if(weight+arr[i].weight<=w){
				//inlclude as whole
				weight+=arr[i].weight;
				profit += arr[i].value;
			}else{
				int rem = w-weight;
				profit+= ((double)arr[i].value)/((double)arr[i].weight)*((double)rem);
				break;
			}
		}
		return profit;
	}
}

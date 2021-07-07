package Day01;

public class MergeTwoSortedArraysWithoutExtraSpace {
	public static void main(String[] args) {
		int[] arr = {1,4,5,7,8,9};
		int[] arr2 = {2,3,6};
		merge(arr, arr2);
		for(int x:arr){
			System.out.print(x+" ");
		}
		for(int x:arr2){
			System.out.print(x+" ");
		}
	}
	// O(m*n)
	static void merge(int[] a1, int[] a2){
		int i=0,j=0;
		while(i<a1.length && j<a2.length){
			if(a1[i]>a2[j]){
				int temp = a1[i];
				a1[i] = a2[j];
				a2[j] = temp;
				insertionSort(a2);
			}
			i++;
		}
	}
	static void insertionSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			int key = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>key){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
}

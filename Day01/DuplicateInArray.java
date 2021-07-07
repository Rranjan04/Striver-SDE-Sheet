package Day01;

public class DuplicateInArray {
	public static void main(String[] args) {
		duplicates(new int[]{1,2,3,1,3,6,6});
	}
	static void duplicates(int[] arr){
		for(int i=0;i<arr.length;i++){
			int index = Math.abs(arr[i]);
			if(arr[index-1]>0){
				arr[index-1] = -arr[index-1];
			}else{
				System.out.println(arr[i]);
			}
		}
	}
	static int find(int[] arr){
		//floyd cycle detection algorithm- comparing to LL
		if(arr.length==1) return -1;
		int slow = arr[0] , fast = arr[arr[0]];
		while(slow!=fast){
			slow = arr[slow];
			fast = arr[arr[fast]];
		}
		slow = 0;
		while(slow!=fast){
			slow = arr[slow];
			fast = arr[fast];
		}
		return slow;

	}
}

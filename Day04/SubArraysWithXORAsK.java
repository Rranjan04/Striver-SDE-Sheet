package Day04;

import java.util.HashMap;

public class SubArraysWithXORAsK {
	public static void main(String[] args) {
		
	}
	static int count(int[] arr, int k){
		HashMap<Integer,Integer> map = new HashMap<>(); 
		int xor = 0;
		int count = 0;
		map.put(0,1);
		for(int x:arr){
			xor=xor^x;
			int y = xor^k;
			if(map.containsKey(y)){
				count+=map.get(y);
			}
			if(!map.containsKey(xor)){
				map.put(xor, map.get(xor)+1);
			}else{
				map.put(xor, 1);
			}
		}
		return count;
	}
}

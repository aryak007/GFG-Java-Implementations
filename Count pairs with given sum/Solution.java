import java.util.*;

class Solution{
	public static void main(String args[]){
		int arr[] = {1,5,7,-1};
		countPairs(arr,6);
	}

	static void countPairs(int arr[],int sum){
		int count = 0;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0;i<arr.length;i++){
			if(map.containsKey(arr[i]))
				map.put(arr[i],map.get(arr[i])+1);
			else
				map.put(arr[i],0);

		}

		for(int i =0;i<arr.length;i++){
			if(map.containsKey(sum-arr[i])){
				count++;

			}
		}
		System.out.println(count);
	}
}
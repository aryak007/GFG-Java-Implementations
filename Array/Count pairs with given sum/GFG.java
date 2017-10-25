/*

*/


import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		GFG g = new GFG();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k =  Integer.parseInt(st.nextToken());
			int arr[] = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			System.out.println(g.countPairs(arr, n, k));
			//g.printArr(arr,n);
			//System.out.println();
		}
	}
	int countPairs(int arr[], int n, int k) {
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(arr[i]))
				map.put(arr[i], 0);
			map.put(arr[i], map.get(arr[i]) + 1);
		}

		for (int i = 0; i < n; i++) {
			if (map.containsKey(k - arr[i])) {
				if ((map.get(k - arr[i]) > 0) && (map.get(arr[i]) > 0)) {
					count = count + 1;
					map.put(arr[i],map.get(arr[i]) - 1);
					map.put(k-arr[i],map.get(k-arr[i]) - 1);
				}
			}
		}

		return count ;
	}

}
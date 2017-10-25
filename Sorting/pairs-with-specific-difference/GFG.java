/*
Input  : A[] = {3, 5, 10, 15, 17, 12, 9}, K = 4
Output : 62
Then disjoint pairs with difference less than K are,
(3, 5), (10, 12), (15, 17)
max sum which we can get is 3 + 5 + 10 + 12 + 15 + 17 = 62
Note that an alternate way to form disjoint pairs is,
(3, 5), (9, 12), (15, 17), but this pairing produces less sum.

Input  : A[] = {5, 15, 10, 300}, k = 12
Output : 25
*/


import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		GFG g = new GFG();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(br.readLine());
			System.out.println(g.maxSumPairWithDifferenceLessThanK(arr, n, k));
		}
	}

	int maxSumPairWithDifferenceLessThanK(int arr[], int n, int k) {
		Arrays.sort(arr);
		int maxSum = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] - arr[i - 1] < k) {
				maxSum = maxSum + arr[i] + arr[i - 1];
				i--;
			}
		}
		return maxSum;
	}
}
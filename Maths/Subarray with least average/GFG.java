/*
Find the subarray with least average of size K. Given an array arr[] of size n and integer k such that k <= n.

Input:
The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line contains an integer 'N' and 'K' denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.


Output:
The first and last index of the subarray. (Index begins from 1).

Note: You may assume that there will only be one unique solution.


Constraints:
1<=T<=30
1<=N<=1000
1<=K<=N
1<=A[i]<=103

Example:
Input:
1
3 1
30 20 10

Output:
3 3
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
			int k = Integer.parseInt(st.nextToken());
			int arr[] = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			g.subarrayWithLeastAverage(arr, n, k);
			//System.out.println();
		}
	}
	void subarrayWithLeastAverage(int arr[], int n, int k) {
		if (n == k){
			System.out.println("0 " + (n - 1))	;
			return;
		}
		int currentSum = 0,i,first,last;
		for (i = 0; i < k; i++)
			currentSum += arr[i];

		double minAvg = currentSum/k,avg;
		first = 1;
		last = k;
		for (i = 0; i < n-k; i++) {
			currentSum = currentSum-arr[i];
			currentSum = currentSum+arr[i+k];
			avg = currentSum/k;
			if(avg<=minAvg)
			{
			   
				minAvg = avg;
				first = i+2;
				last = i+k+1;
				System.out.println(first+" "+last);
			}
		}
		System.out.println(first+" "+last);
	}
}
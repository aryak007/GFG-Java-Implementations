/*
Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array such that the integers in the subsequence are sorted in increasing order.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the size of array.
The second line of each test case contains N input A[].

Output:

Print the sum of maximum sum sequence of the given array.

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 100
1 ≤ A[] ≤ 1000

Example:

Input:
2
7
1 101 2 3 100 4 5
4
10 5 4 3

Output:
106
10

Explanation:
For input:
7
1 101 2 3 100 4 5
All the increasing subsequences : (1,101); (1,2,3,100); (1,2,3,4,5), out of this (1,2,3,100) has maximum sum,i.e., 106. Hence the output is stated as 106.
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
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(st.nextToken());
			System.out.println(g.calculateLIS(arr,n));

		}
	}

	int calculateLIS(int[] arr, int n) {
		int lisSum[] = new int[n];
		int i,j;
		for(i = 0;i<n;i++)
			lisSum[i] = arr[i];

		for(i = 1;i<n;i++){
			for(j = 0;j<i;j++){
				if(arr[j]<arr[i] )
					lisSum[i] = Math.max(lisSum[i],lisSum[j]+arr[i]);
			}
		}
		int max = Integer.MIN_VALUE;
		for(i = 0;i<n;i++)
			if(max<lisSum[i])
				max = lisSum[i];
		return max;
	}

}
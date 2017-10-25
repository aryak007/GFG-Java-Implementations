/*
Given an array A your task is to tell at which position the equilibrium first occurs in the array. Equilibrium position in an array is a position such that the sum of elements below it is equal to the sum of elements after it.

Input:
The first line of input contains an integer T denoting the no of test cases then T test cases follow. First line of each test case contains an integer N denoting the size of the array. Then in the next line are N space separated values of the array A.

Output:
For each test case in a new  line print the position at which the elements are at equilibrium if no equilibrium point exists print -1.

Constraints:
1<=T<=100
1<=N<=100

Example:
Input:
2
1
1
5
1 3 5 2 2

Output:
1
3

Explanation:
1. Since its the only element hence its the only equilibrium point
2. For second test case equilibrium point is at position 3 as elements below it (1+3) = elements after it (2+2)
 

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
			int arr[] = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			System.out.println(g.findEquilibriumPoint(arr, n));
		}
	}

	int findEquilibriumPoint(int arr[], int n) {
		int leftSum[] = new int[n];
		leftSum[0] = arr[0];
		
		for(int i = 1;i<n;i++)
			leftSum[i] = leftSum[i-1]+arr[i];

		int sum = 0;
		for(int i = n-1;i>=0;i--)
			{
				sum = sum+arr[i];
				if(sum==leftSum[i])
					return (i+1);
			}
		return -1;
	}
}
/*
Given a N X N  matrix Matrix[N][N] of positive integers.  There are only three possible moves from a cell Matrix[r][c].

1. Matrix[r+1][c]

2. Matrix[r+1][c-1]

3. Matrix[r+1][c+1]

Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.

Input:
The first line of the input contains an integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N denoting the order of matrix. Next line contains N*N integers denoting the elements of the matrix in row-major form.

Output:
Output the largest sum of any of the paths starting from any cell of row 0 to any cell of row N-1. Print the output of each test case in a new line.

Constraints:
1<=T<=20
2<=N<=20
1<=Matrix[i][j]<=1000 (for all 1<=i<=N && 1<=j<=N)

Example:

Input:
1
2
348 391 618 193

Output:
1009

Explanation: In the sample test case, the path leading to maximum possible sum is 391->618.  (391 + 618 = 1009)
*/

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

class GFG {
	public static void main(String args[]) throws IOException {
		GFG g = new GFG();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int arr[][] = new int[n][n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println(g.findMathPathCost(arr,n));

		}
	}
	
	int findMathPathCost(int arr[][], int n) {

		int dp[][] = new int[n][n];
		int i, j, max = 0;

		for(i = 0;i<n;i++){
			dp[0][i] = arr[0][i];
		}
		for (i = 1; i < n ; i++) {
			for (j = 0; j < n ; j++) {

				if(j==0)
					dp[i][j] = Math.max(dp[i-1][j+1],dp[i-1][j])+arr[i][j];
				

				else if(j==n-1)
					dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+arr[i][j];
				
				else
					dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i-1][j - 1], dp[i - 1][j + 1])) + arr[i][j];

			}
		}
		for(i = 0;i<n;i++){
			if (max < dp[n-1][i])
					max = dp[n-1][i];
		}


		
		return max;
	}
}


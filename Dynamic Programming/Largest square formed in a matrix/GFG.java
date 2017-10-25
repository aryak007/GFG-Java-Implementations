/*
Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is n and m,n is the number of rows and m is the number of columns.
The second line of each test case contains array C[n][m] in row major form.

Output:

Print maximum size square sub-matrix.

Constraints:

1 ≤ T ≤ 100
1 ≤ n,m ≤ 50
0 ≤ C[n][m] ≤ 1

Example:

Input:
3
5 6
0 1 0 1 0 1 1 0 1 0 1 0 0 1 1 1 1 0 0 0 1 1 1 0 1 1 1 1 1 1
2 2
1 1 1 1
2 2
0 0 0 0

Output:
3
2
0
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
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int arr[][] = new int[m][n];

			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<m;i++){
				for(int j = 0;j<n;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println(g.largestSubSquare(arr, m, n));

		}
	}
	int largestSubSquare(int arr[][], int m, int n) {

		int dp[][] = new int[m+1][n+1];
		int i,j,max = 0;
		
		for(i=1;i<m+1;i++){
			for(j=1;j<n+1;j++){
				if(arr[i-1][j-1]==1){
					dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
					if(max<dp[i][j])
						max = dp[i][j];
				}

			}
		}
		return max;
	}
}


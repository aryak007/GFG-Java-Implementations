/*
Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins. The order of coins doesn’t matter. For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

Input:

The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line contains an integer 'M' denoting the size of array. The second line contains M space-separated integers A1, A2, ..., AN denoting the elements of the array. The third line contains an integer 'N' denoting the cents.

Output:

Print number of possible ways to make change for N cents.

Constraints:

1 ≤ T ≤ 50
1 ≤ N ≤ 300
1 1 ≤ A[i] ≤ 300

Example:

Input:

2
3
1 2 3
4
4
2 5 3 6
10

Output:

4
5


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


			int m = Integer.parseInt(br.readLine());
			int coins[] = new int[m];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			int n = Integer.parseInt(br.readLine());
			System.out.println(g.coinChange(coins, m, n));

		}
	}

	int coinChange(int coins[], int m, int n) {

		int dp[][] = new int[m+1][n + 1];
		int i, j;
		for (i = 0; i < m; i++)
			dp[i][0] = 1;

		for (i = 1; i <=m; i++) {
			for (j = 1; j <=n ; j++) {
				if (coins[i-1] > j){
					//System.out.println("if i "+i+" j "+j);
					dp[i][j] = dp[i - 1][j];
				}
				else{
					//System.out.println("else i "+i+" j "+j);
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i-1]];
				}
			}
		}
		return dp[m][n];

	}
}


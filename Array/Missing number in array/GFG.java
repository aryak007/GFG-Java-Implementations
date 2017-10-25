/*
Given an array of size n-1 and given that there are numbers from 1 to n with one missing, the missing number is to be found.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N.
The second line of each test case contains N-1 input C[i],numbers in array.

Output:

Print the missing number in array.

Constraints:

1 ≤ T ≤ 200
1 ≤ N ≤ 1000
1 ≤ C[i] ≤ 1000

Example:

Input
2
5
1 2 3 5
10
1 2 3 4 5 6 7 8 10

Output
4
9
 
*/

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		GFG g = new GFG();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(st.nextToken());
			int arr[] = new int[n-1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n-1; i++)
				arr[i] = Integer.parseInt(br.readLine());
			g.findMissingNumber(arr, n);
			//System.out.println();
		}
	}

	void findMissingNumber(int arr[], int n) {
		int xor = arr[0];
		for(int i  =1;i<n-1;i++)
			xor = xor^arr[i];
		for(int i = 1;i<=n;i++)
			xor = xor^i;
		System.out.println(xor);
	}
}
/*
Given a sequence, find the length of the longest increasing subsequence from a given sequence .
The longest increasing subsequence means to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest
to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.

Note: Duplicate numbers are not counted as increasing subsequence.

For example:
 length of LIS for 
{ 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.

 

Input:

The first line contains an integer T, depicting total number of test cases. 
Then following T lines contains an integer N depicting the size of array and next line followed by the value of array.


Output:

Print the Max length of the subsequence in a separate line.


Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 1000
0 ≤ A[i] ≤ 300

Example:

Input
1
16
0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15
Output
6

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
		int lis[] = new int[n];
		int i,j;
		for(i = 0;i<n;i++)
			lis[i] = 1;

		for(i = 1;i<n;i++){
			for(j = 0;j<i;j++){
				if(arr[j]<=arr[i])
					lis[i] = Math.max(lis[i],lis[j]+1);
			}
		}
		int max = Integer.MIN_VALUE;
		for(i = 0;i<n;i++)
			if(max<lis[i])
				max = lis[i];
		return max;
	}

}

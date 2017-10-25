/*
A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
You are an FBI agent. You have to determine the total number of ways that message can be decoded.
Note: An empty digit sequence is considered to have one decoding. It may be assumed that the input contains valid digits from 0 to 9 and If there are leading 0’s, extra trailing 0’s and two or more consecutive 0’s then it is an invalid string.

Example :
Given encoded message "123",  it could be decoded as "ABC" (1 2 3) or "LC" (12 3) or "AW"(1 23).
So total ways are 3.

Input:
First line contains the test cases T.  1<=T<=1000
Each test case have two lines
First is length of string N.  1<=N<=40
Second line is string S of digits from '0' to '9' of N length.

Example:
Input:
2
3
123
4
2563
Output:
3
2

*/


import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		GFG g = new GFG();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String input = br.readLine();
			char arr[] = input.toCharArray();
			System.out.println(g.waysToDecodeMessage(arr,arr.length));

		}
	}

	int waysToDecodeMessage(char[] arr, int n) {
		int count[] = new int[n + 1]; // A table to store results of subproblems
		count[0] = 1;
		count[1] = 1;

		for (int i = 2; i <= n; i++) {
			count[i] = 0;

			
			if (arr[i - 1] > '0')
				count[i] = count[i - 1];

			if (arr[i - 2] == '1' || (arr[i - 2] == '2' && arr[i - 1] < '7'))
				count[i] += count[i - 2];
		}
		return count[n];
	}

}

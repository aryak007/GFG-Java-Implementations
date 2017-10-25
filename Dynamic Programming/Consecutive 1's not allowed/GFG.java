/*
Count number of binary strings without consecutive 1’s

Problem Description:
Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1’s. Output your answer mod 10^9 + 7.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
Each test case contain an integer N representing length of the binary string.

Output:
Print the count number of binary strings without consecutive 1’s of length N.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 100

Example:
Input:
2
3
2

Output:
5
3

Explaination:
For first test case 5 strings are (000, 001, 010, 100, 101)
For second test case 3 strings are (00,01,10)

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
			System.out.println(g.countBinaryStrings(n));

		}
	}
	int countBinaryStrings(int n){
		int countEndingAtZeroes[] = new int[n];
		int countEndingAtOnes[] = new int[n];
		countEndingAtZeroes[0] = countEndingAtOnes[0] = 1;
		for(int i = 1;i<n;i++){
			countEndingAtZeroes[i] = countEndingAtZeroes[i-1]+countEndingAtOnes[i-1];
			countEndingAtOnes[i] = countEndingAtZeroes[i-1];
		}
		return countEndingAtZeroes[n-1]+countEndingAtOnes[n-1];
	}
}
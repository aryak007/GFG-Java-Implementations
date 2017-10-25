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
			int n = Integer.parseInt(br.readLine());
			System.out.println(g.printNthUglyMNumber(n));
		}
	}

	int printNthUglyMNumber(int n){
		int ugly[] = new int[n];
		int i2=0,i3=0,i5=0;
		int nextUglyNo;

		int next_multilple_of_2 = 2;
		int next_multilple_of_3 = 3;
		int next_multilple_of_5 = 5;
		ugly[0] = 1;
		for(int i = 1;i<n;i++){
			nextUglyNo = Math.min(next_multilple_of_2,Math.min(next_multilple_of_3,next_multilple_of_5));
			ugly[i] = nextUglyNo;
			if(nextUglyNo==next_multilple_of_2){
				i2 = i2+1;
				next_multilple_of_2 = 2*ugly[i2];
			}

			if(nextUglyNo==next_multilple_of_3){
				i3 = i3+1;
				next_multilple_of_3 = 3*ugly[i3];
			}

			if(nextUglyNo==next_multilple_of_5){
				i5 = i5+1;
				next_multilple_of_5 = 5*ugly[i5];
			}
		}
		return ugly[n-1];
	}
}
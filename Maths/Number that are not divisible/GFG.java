/*
You will be given a positive integer N. Your task is to find the number of positive integers K ≤ N such that K is not divisible by any number among the set {2,3,4,5,6,7,8,9,10}.

 

Input: 
The first line of input contains a single integer T denoting the number of test cases.
Then T test cases follow. The first and only line of each test case consists of N.
 

Output:
Corresponding to each test case, in a new line, print the number positive integers less than or equal to N which are not divisible by any number from 2 to 10.

 

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 1018
 

Example:

Input
3
200
400
500

Output
47
91
115
*/
import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		GFG g = new GFG();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			long n = Long.parseLong(br.readLine());
			System.out.println(g.countNumbers(n));
		}
	}

	long countNumbers(long n){
		return (n-(n/2)-(n/3)-(n/5)-(n/7)+(n/6)+(n/10)+(n/14)+(n/15)+(n/21)+(n/35)-(n/30)-(n/42)-(n/70)-(n/105)+(n/210));

	}

	
}
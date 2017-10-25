/*

Given a positive integer, return its corresponding column title as appear in an Excel sheet.
MS Excel columns has a pattern like A, B, C, … ,Z, AA, AB, AC,…. ,AZ, BA, BB, … ZZ, AAA, AAB ….. etc. In other words, column 1 is named as “A”, column 2 as “B”, column 27 as “AA”.

Input:

The first line of each input consists of the test cases. And, the second line consists of a number N.

Output:

In each separate line print the corresonding column title as it appears in an Excel sheet.

Constraints:

1 ≤ T ≤ 70
1 ≤ N ≤ 4294967295

Example:

Input:

2
28
13

Output:

AB
M

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
			long n = Long.parseLong(br.readLine());
			System.out.println(g.findColumnName(n));

		}
	}

	String findColumnName(long n) {
		long rem = 0;
		String result = "";
		while(n>0)
		{
			rem = n%26;
			if(rem == 0){
				result = 'Z'+result;
				n = n-26;
			}
			else
				result = (char)(64+rem)+result;
			n = n/26;
		}
		return result;
	}
}
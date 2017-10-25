/*
For a given string delete the elements which are appearing more than once consecutively. All letters are of lowercase.

Input:
The first line contains an integer 'T' denoting the total number of test cases. In each test cases,  a string will be inserted.


Output:
In each seperate line the modified string should be output.


Constraints:
1<=T<=31
1<=length(string)<=100


Example:
Input:
1
aababbccd

Output:
ababcd
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
			g.consecutiveElements(input.toCharArray());
			System.out.println();

		}
	}
	void consecutiveElements(char[] str){
		int n = str.length;
		char elem;
		for(int i  =0;i<n;i++){
			while(i<n-1 && str[i]==str[i+1])
				i++;
			System.out.print(str[i]);
		}
	}
}
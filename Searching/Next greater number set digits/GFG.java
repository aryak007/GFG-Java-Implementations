/*

Given a number n, find the smallest number that has same set of digits as n and is greater than n. If x is the greatest possible number with its set of digits, then print “not possible”.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is n,n is the number.

Output:

Print the greater number than n with same set of digits and if not possible then print "not possible" without double quote.

Constraints:

1 ≤ T ≤ 100
1 ≤ n ≤ 100000

Example:

Input
2
143
431

Output
314
not possible

*/
import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

class GFG {
	static TreeSet<String> list = new TreeSet<String>();
	public static void main(String args[]) throws IOException {
		GFG g = new GFG();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String n = br.readLine();
			System.out.println(g.nextGreater(n));

		}
	}
	static String nextGreater(String n){
		int num = Integer.parseInt(n);
		int no = 0;
		permute(n,0,n.length()-1);
		Iterator i = list.iterator();
		boolean flag = false;
		while(i.hasNext()){
			no = Integer.parseInt((String)(i.next()));
			if(no>num){
				flag = true;
				break;
			}
		}
		if(flag)
			return Integer.toString(no);
		return "not possible";
	}

	static void permute(String n,int i,int j){
		if(i==j)
	        list.add(n);
	    else
	    {
	        for(int k=i;k<=j;k++)
	        {
	            n=swap(n,i,k);
	            permute(n,i+1,j);
	            n=swap(n,i,k);
	        }
	    }
	}
	static String swap(String str,int i,int j){
		StringBuilder sb = new StringBuilder(str);
		char ch = str.charAt(i);
		sb.setCharAt(i,str.charAt(j));
		sb.setCharAt(j,ch);
		return sb.toString();
	}
}
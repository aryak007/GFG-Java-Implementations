/*
Given a positive integer N, check if N is a power of 2.

Input:
The first line contains 'T' denoting the number of test cases. Then follows description of test cases.
Each test case contains a single positive integer N.


Output:
Print "YES" if it is a power of 2 else "NO". (Without the double quotes)


Constraints:
1<=T<=100
0<=N<=10^18

Example:
Input :
2
1
98

Output :
YES
​NO
*/
import java.io.*;
import java.math.BigInteger;
class GFG{

	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			String n = br.readLine();
			if(n.equals("0"))
			{
				System.out.println("NO");
				break;
			}
			BigInteger input = new BigInteger(n);
			BigInteger oneMinusInput = input.subtract(BigInteger.ONE);
			if((input.and(oneMinusInput)).equals(BigInteger.ZERO))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
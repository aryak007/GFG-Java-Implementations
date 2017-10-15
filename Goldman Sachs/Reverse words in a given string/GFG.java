/*
Given a String of length N reverse the words in it. Words are separated by dots.

Input:
The first line contains T denoting the number of testcases. Then follows description of testcases. Each case contains a string containing spaces and characters.
 

Output:
For each test case, output a single line containing the reversed String.

Constraints:
1<=T<=20
1<=Lenght of String<=2000


Example:
Input:
2
i.like.this.program.very.much
pqr.mno

Output:
much.very.program.this.like.i
mno.pqr
*/

import java.io.*;
import java.util.regex.Pattern;
class GFG{
    public static void main(String args[]) throws IOException{
        GFG g = new GFG();
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Pattern pattern = Pattern.compile("\\.");
        while(t-->0){
			String input = br.readLine();
			String arr[] = pattern.split(input);
			g.printWordReverse(arr);          
        }
    }

    void printWordReverse(String arr[]){
    	String res = arr[0];
    	for(int i = 1;i<arr.length;i++){
    		res = arr[i]+"."+ res;
    	}
    	System.out.println(res);
    }
}
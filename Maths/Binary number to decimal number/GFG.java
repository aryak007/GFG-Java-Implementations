/*

*/

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		GFG g = new GFG();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			char[] binary = br.readLine().toCharArray();

			System.out.println(g.decimalEquivalent(binary));
		}
	}

	int decimalEquivalent(char[] binary) {
		int d = 0;
		int n = binary.length;
		for(int i = n-1;i>=0;i--){
			if(binary[i]=='1'){
				System.out.println(i);
				d = d+(int)Math.pow(2,n-i-1);
			}
		}
		return d;
	}
}
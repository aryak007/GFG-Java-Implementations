import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

class GFG {
	public static void main(String args[]) throws IOException {
		GFG g = new GFG();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {

			String N = br.readLine();
			System.out.println(g.calculateSumOfSubstring(N));

		}
	}

	int calculateSumOfSubstring(String N){
		int n = N.length();
         
        //  allocate memory equal to length of string
        int sumofdigit[] = new int[n];
      
        //  initialize first value with first digit
        sumofdigit[0] = N.charAt(0)-'0';
        int res = sumofdigit[0];
      
       
        for (int i = 1; i < n; i++)
        {
            int numi = N.charAt(i)-'0';
      
            //Formula
            sumofdigit[i] = (i+1) * numi +
                            10 * sumofdigit[i-1];
      
            res += sumofdigit[i];
        }
      
        return res;
	}
	
}


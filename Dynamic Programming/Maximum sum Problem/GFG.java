
import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		GFG g = new GFG();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			System.out.println(g.calculateMaxSum(n));

		}
	}

	int calculateMaxSum(int n){
		int dp[] = new int[n+1];
  
        dp[0] = 0;  dp[1] = 1;
        for (int i=2; i<=n; i++)
           dp[i] = Math.max(dp[i/2] + dp[i/3] + dp[i/4], i);
      
        return dp[n]; 
	}



}
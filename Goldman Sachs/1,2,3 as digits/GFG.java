import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    GFG g = new GFG();
	    while(t-->0){
	    	int n = Integer.parseInt(br.readLine());
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	int arr[] = new int[n];
	    	for(int i = 0;i<n;i++)
	    		arr[i] = Integer.parseInt(st.nextToken());
	    	g.countAllPossibleDecodings(arr,n)
	    }
	}
	public void findMinCost(int arr[],int n){
		int count[n+1]; // A table to store results of subproblems
	    count[0] = 1;
	    count[1] = 1;
	 
	    for (int i = 2; i <= n; i++)
	    {
	        count[i] = 0;
	 
	        // If the last digit is not 0, then last digit must add to
	        // the number of words
	        if (arr[i-1] > '0')
	            count[i] = count[i-1];
	 
	        // If second last digit is smaller than 2 and last digit is
	        // smaller than 7, then last two digits form a valid character
	        if ((arr[i-2] == '1' || arr[i-2] == '2') && arr[i-1] < '7')
	            count[i] += count[i-2];
	    }
	    return count[n];
	}
}
import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    GFG g = new GFG();
	    while(t-->0){
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	int n = Integer.parseInt(st.nextToken());
	    	int x = Integer.parseInt(st.nextToken());
	    	int arr[] = new int[n];
	    	st = new StringTokenizer(br.readLine()); 
	    	for(int i = 0;i<n;i++)
	    		arr[i] = Integer.parseInt(st.nextToken());
	    	System.out.println(g.findMinLengthSubarrayEfficient(arr,n,x));
	    }
	}
	int findMinLengthSubarrayEfficient(int arr[],int n,int x){
		 int curr_sum = 0, min_len = n + 1;
 
        // Initialize starting and ending indexes
        int start = 0, end = 0;
		while (end < n) 
        {
            // Keep adding array elements while current sum
            // is smaller than or equal to x
            while (curr_sum <= x && end < n)
                curr_sum += arr[end++];
 
            // If current sum becomes greater than x.
            while (curr_sum > x && start < n) 
            {
                // Update minimum length if needed
                if (end - start < min_len)
                    min_len = end - start;

                curr_sum -= arr[start++];
            }
        }
        return min_len;
	}
	
	int findMinLengthSubarray(int arr[],int n,int x){
		
		int minSoFar = Integer.MAX_VALUE;
		int count = 0;
		int i=0,j=0;

		while(i<=j && j<n){
			if(checkSum(arr,i,j,x)){
				count = j-i+1;
				//System.out.println(count + " "+i+" "+j);
				if(minSoFar>count)
					minSoFar = count;
				i++;
			}
			else{
				j++;
			}
		}
		return minSoFar;
		
	}

	boolean checkSum(int arr[],int i,int j,int x){
		int sum = 0;
		for(int index = i;index<=j;index++)
		{
			sum+=arr[index];
			if(sum>x)
				return true;

		}
		return false;
	}
}
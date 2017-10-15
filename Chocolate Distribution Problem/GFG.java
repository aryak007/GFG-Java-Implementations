/*
Input : arr[] = {7, 3, 2, 4, 9, 12, 56} 
        m = 3
Output: Minimum Difference is 2
We have seven packets of chocolates and
we need to pick three packets for 3 students
If we pick 2, 3 and 4, we get the minimum
difference between maximum and minimum packet
sizes.

Input : arr[] = {3, 4, 1, 9, 56, 7, 9, 12} 
        m = 5
Output: Minimum Difference is 6
The set goes like 3,4,7,9,9 and the output 
is 9-3 = 6

Input : arr[] = {12, 4, 7, 9, 2, 23, 25, 41,
                 30, 40, 28, 42, 30, 44, 48, 
                 43, 50} 
        m = 7
Output: 10
We need to pick 7 packets. We pick 40, 41,
42, 44, 48, 43 and 50 to minimize difference
between maximum and minimum.
*/
import java.io.*;
import java.util.*;

class GFG{
	public static void main(String args[]) throws IOException{
		GFG g = new GFG();
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0;i<n;i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int m = Integer.parseInt(br.readLine());
			System.out.println(g.calculateMinDiff(arr,n,m));
			
		}
    }

    public int calculateMinDiff(int arr[],int n,int m){
    	Arrays.sort(arr);
    	int l = 0;
    	int h = l + m - 1;
    	int diff;
    	int minDiffSoFar = Integer.MAX_VALUE;
    	while(h<n){
    		//System.out.println(h);
    		diff = arr[h]-arr[l];
    		if(diff<minDiffSoFar)
    			minDiffSoFar = diff;
    		l++;
    		h++;
    	}
    	return minDiffSoFar;
    }

}

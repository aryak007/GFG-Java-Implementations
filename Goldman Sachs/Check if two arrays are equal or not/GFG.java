/*
Given two arrays of equal length, the task is to find if given arrays are equal or not. Two arrays are said to be equal if both of them contain same set of elements, arrangements (or permutation) of elements may be different though.

Note : If there are repetitions, then counts of repeated elements must also be same for two array to be equal.

Examples:

Input  : A[] = {1, 2, 5, 4, 0};
         B[] = {2, 4, 5, 0, 1}; 
Output : 1

Input  : A[] = {1, 2, 5};
         B[] = {2, 4, 15}; 
Output : 0


Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.  Each test case contains an integer N denoting the size of the array. Then in the next two lines are N space separated values of the array of arrays A[] and B[].

Output:
For each test case in a new line print 1 if the arrays are equal else print 0.

Constraints:
1<=T<=100
1<=N<=100
1<=A[],B[]<=1000

Example:
Input:
2
5
1 2 5 4 0
2 4 5 0 1
3
1 2 5
2 4 15
Output:
1
0
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
            int a[] = new int[n];
            int b[] = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0;i<n;i++)
            	a[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
			for(int i = 0;i<n;i++)
            	b[i] = Integer.parseInt(st.nextToken());
            if(g.checkIfEqual(a,b,n))
            	System.out.println("1");
            else
            	System.out.println("0");
            
        }
    }

    boolean checkIfEqual(int a[],int b[],int n){
    	 HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
            for(int i=0;i<n;i++){
            	if(map.containsKey(a[i]))
            		map.put(a[i],map.get(a[i])+1);
            	else
            		map.put(a[i],1);
            }

            for(int i=0;i<n;i++){
            	if(map.containsKey(b[i])){
            		if(map.get(b[i])==0)
            		{
            			return false;
            		}
            		else{
            			map.put(b[i],map.get(b[i])-1);
            		}
            	}
            	else
            		return false;
            }
            return true;
    }
}

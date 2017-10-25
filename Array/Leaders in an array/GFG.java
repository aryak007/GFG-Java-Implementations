/*
Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side. The rightmost element is always a leader. 

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N denoting the size of array.
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print all the leaders.

Constraints:
1 <= T <= 100
1 <= N <= 100
0 <= A[i]<=100

Example:
Input:
2
6
16 17 4 3 5 2
5
1 2 3 4 0
Output:
17 5 2
4 0
*/

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		GFG g = new GFG();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(st.nextToken());
			g.printLeaders(arr,n);

		}
	}

	void printLeaders(int arr[],int n){
		int leaders[] = new int[n];
		leaders[n-1] = arr[n-1];
		for(int i = n-2;i>=0;i--){
			leaders[i] = Math.max(leaders[i+1],arr[i]);
		}

		/*for(int i  = 0;i<n;i++)
			System.out.print(leaders[i]+" ");
		*/

		for(int i =0;i<n;i++){
			while (i < n-1 && leaders[i] == leaders[i+1])
          		i++;
          	System.out.print(leaders[i]+" ");
		}

	}
}
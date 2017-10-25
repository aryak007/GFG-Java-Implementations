/*
Given an array of integers, sort the array into a wave like array and return it. 
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

Example

Given [1, 2, 3, 4]

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
 NOTE : If there are multiple answers possible, return the one thats lexicographically smallest. 

 

Input:

The first line contains an integer T, depicting total number of test cases. 
Then following T lines contains an integer N depicting the size of square matrix and next line followed by the value of array.


Output:

Print the array into wave like array.


Constraints:

1 ≤ T ≤ 30
1 ≤ N ≤ 100
0 ≤ A[i] ≤ 100

Example:

Input
1
5
5 7 3 2 8
Output
3 2 7 5 8
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
			int arr[] = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			g.waveArray(arr, n);
			System.out.println();
		}
	}

	void waveArray(int arr[], int n) {
		Arrays.sort(arr);

		for(int i = 0;i<n-1;i+=2){
			swap(arr,i,i+1);
		}
		for(int i = 0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}
	void swap(int arr[],int i,int j){
		int temp = arr[i];
		arr[i] = arr[i+1];
		arr[i+1] = temp;
	}
}
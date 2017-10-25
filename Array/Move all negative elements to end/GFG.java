/*
Given an unsorted array having both negative and positive integers. The task is place all negative element at the end of array without changing the order of positive element and negative element.

Examples:

Input : A[] = {1, -1, 3, 2, -7, -5, 11, 6 }
Output : 1  3  2  11  6  -1  -7  -5

Input : A[] = {-5, 7, -3, -4, 9, 10, -1, 11}
Output : 7  9  10  11  -5  -3  -4  -1

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
For each test case in a new line output the modified array.

Constraints:
1<=T<=100
1<=N<=100
-1000<=A[]<=1000

Example:
Input:
2
8
1 -1 3 2 -7 -5 11 6
8
-5 7 -3 -4 9 10 -1 11
Output:
1 3 2 11 6 -1 -7 -5
7 9 10 11 -5 -3 -4 -1
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
			//g.sortPositiveNegative(arr, 0, n - 1);
			//Arrays.sort(arr);
			g.segregateElements(arr,n);
			g.printArr(arr, n);
			System.out.println();
		}
	}

	void segregateElements(int arr[], int n) {
		// Create an empty array to store result
		int temp[] = new int[n];

		// Traversal array and store +ve element in
		// temp array
		int j = 0; // index of temp
		for (int i = 0; i < n ; i++)
			if (arr[i] >= 0 )
				temp[j++] = arr[i];

		// If array contains all positive or all negative.
		if (j == n || j == 0)
			return;

		// Store -ve element in temp array
		for (int i = 0 ; i < n ; i++)
			if (arr[i] < 0)
				temp[j++] = arr[i];

		// Copy contents of temp[] to arr[]
		//Arrays.copy(arr, temp);
		System.arraycopy(temp, 0, arr, 0, arr.length );
	}


	void printArr(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	void sortPositiveNegative(int arr[], int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			sortPositiveNegative(arr, l, m);
			sortPositiveNegative(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}
	void merge(int arr[], int l, int m, int r) {
		int i = 0, j = 0;
		int n1 = m - l + 1;
		int n2 = r - m;
		int L[] = new int[n1];
		int R[] = new int[n2];

		for (i = 0; i < n1; i++)
			L[i] = arr[l + i];

		for (i = 0; i < n2; i++)
			R[i] = arr[m + 1 + i];
		i = j = 0;
		int index = l;
		while (i < n1 && L[i] > 0)
			arr[index++] = L[i++];

		while (j < n2 && R[j] > 0)
			arr[index++] = R[j++];

		while (i < n1)
			arr[index++] = L[i++];

		while (j < n2)
			arr[index++] = R[j++];
	}
}
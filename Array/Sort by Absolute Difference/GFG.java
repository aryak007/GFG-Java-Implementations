/*
Given an array of N distinct elements and a number K, write a program to arrange array elements according to the absolute difference with K, i. e., element having minimum difference comes first and so on.
Note : If two or more elements are at equal distance arrange them in same sequence as in the given array.

Input:
First line of input contains a single integer T which denotes the number of test cases. Then T test cases follows. First line of test case contains two space separated integers N and K. Second line of each test case contains N space separated integers.
Output:
For each test case print the given array in the order as described above.

Constraints:
1<=T<=100
1<=N<=105
1<=K<=103
Example:
Input:
3
5 7
10 5 3 9 2
5 6
1 2 3 4 5
4 5
2 6 8 3
Output:
5 9 10 3 2
5 4 3 2 1
6 3 2 8
*/


import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		GFG g = new GFG();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k =  Integer.parseInt(st.nextToken());
			int arr[] = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			g.sortAbsoluteDiff(arr,0,n-1, n, k);
			g.printArr(arr,n);
			System.out.println();
		}
	}

	void sortAbsoluteDiff(int arr[], int l, int r, int n, int k) {
		if (l < r) {
			int m = (l + r) / 2;
			sortAbsoluteDiff(arr, l, m, n, k);
			sortAbsoluteDiff(arr , m + 1, r, n, k);
			merge(arr, l, m, r, k);
		}
	}

	void printArr(int arr[],int n){
		for(int i = 0;i<n;i++)
			System.out.print(arr[i]+" ");
	}

	void merge(int arr[], int l, int m, int r, int k) {
		int n1 = m - l + 1;
		int n2 = r - m;
		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int index = l;
		while (i < n1 && j < n2) {
			if (Math.abs(L[i] - k) <= Math.abs(R[j] - k)) {
				arr[index] = L[i];
				i++;
			} else {
				arr[index] = R[j];
				j++;
			}
			index++;
		}
		while (i < n1) {
			arr[index] = L[i];
			i++;
			index++;
		}

		while (j < n2) {
			arr[index] = R[j];
			j++;
			index++;
		}

	}
	void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[i + 1];
		arr[i + 1] = temp;
	}
}
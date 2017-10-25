/*
Write a program to sort an array of 0's,1's and 2's in ascending order.

Input:
The first line contains an integer 'T' denoting the total number of test cases. In each test cases, First line is number of elements in array 'N' and second its values.

Output:
Print the sorted array of 0's, 1's and 2's.

Constraints:

1 <= T <= 100
1 <= N <= 100
0 <= arr[i] <= 2

Example:

Input :

2
5
0 2 1 2 0
3
0 1 0


Output:

0 0 1 2 2
0 0 1

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
			g.printSortedArray(arr, n);
			System.out.println();
		}
	}

	void printSortedArray(int arr[], int n) {
		int low = 0;
		int high = n - 1;
		int mid = 0, temp;
		
		while (mid <= high) {
			if (arr[mid] == 0) {
				
					temp = arr[low];
					arr[low] = arr[mid];
					arr[mid] = temp;
					low++;
					mid++;
				
			} else if (arr[mid] == 1) {
				mid++;
			} else {
				
					temp = arr[high];
					arr[high] = arr[mid];
					arr[mid] = temp;
					high--;
				
			}
		}
		for (int i  = 0; i < n; i++)
				System.out.print(arr[i] + " ");
	}
}
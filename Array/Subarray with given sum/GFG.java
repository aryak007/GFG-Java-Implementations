/*
Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a given number.

Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

Output:

Corresponding to each test case, in a new line, print the starting and ending positions of first such occuring subarray if sum equals to subarray, else print -1.

Note: Position of 1st element of the array should be considered as 1.

Expected Time Complexity: O(n)

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 100
1 ≤ an array element ≤ 200

Example:

Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10

Output:
2 4
1 5

Explanation : 
In first test case, sum of elements from 2nd position to 4th position is 12
In second test case, sum of elements from 1st position to 5th position is 15
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
			int s =  Integer.parseInt(st.nextToken());
			int arr[] = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			g.handleNegativeFindContinuousSubArray(arr, n, s);
		}
	}

	public void handleNegativeFindContinuousSubArray(int arr[],int n,int s){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int currSum = 0;
		for(int i = 0;i<n;i++){
			currSum = currSum+arr[i];
			if(currSum==s)
			{
				System.out.println("1 "+(i+1));
				return;
			}
			if(map.containsKey(currSum-s)){
				System.out.println((map.get(currSum-s)+2)+" "+(i+1));
				return;
			}
			map.put(currSum,i);
		}
		System.out.println("-1");
	}
	public void findContinuousSubArray(int arr[],int n,int s)
	{
		boolean flag= false;
		int currSum = 0;
		int start = 0;
		int end = 0;
		//currSum = 0;
		while(end<n){
			currSum = currSum+arr[end];
			if(currSum==s){
				flag = true;
				break;
			}
			else if(currSum<s){
				end++;
			}
			else{
				start++;
				end =start;
				currSum = 0;
			}	
		}
		if(flag){
			System.out.println((start+1)+" "+(end+1));
		}
		else{
			System.out.println("-1");
		}
	}
}
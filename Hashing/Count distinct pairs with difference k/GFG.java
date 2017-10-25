/*
Given an integer array and a non-negative integer k, count all distinct pairs with difference equal to k, i.e., A[ i ] - A[ j ] = k.


Input:

The first line of input consists number of the test cases. The description of T test cases is as follows:

The first line of each test case contains the size of the array, the second line has the elements of the array and the third line consists of the difference k.

Output:

In each separate line print the number of times difference k exists between the elements of the array.


Constraints:

1 ≤ T ≤ 100
1 ≤ N≤ 100
0≤K≤100
0 ≤ A[i] ≤ 10000


Example:

Input:

3
5 
1 5 4 1 2
0
3
1 1 1
0
3 
1 5 3
2

Output:

1
1
2
*/

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

class GFG {
	class Pair{
		int a;
		int b;
		Pair(int a,int b){
			this.a = a;
			this.b = b;
		}
	}
	public static void main(String args[]) throws IOException {
		GFG g = new GFG();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0;i<n;i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int k = Integer.parseInt(br.readLine());
			System.out.println(g.countDistinctPairs(arr, n, k));

		}
	}
	int countDistinctPairs(int arr[], int n, int k) {
		int count = 0;

		Comparator<Pair> comp = new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if((p1.a == p2.a) && (p1.b==p2.b))
                	return 0;
                return -1;
            }
        };
		Set<Pair> set = new TreeSet<Pair>(comp);
		HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();

		for(int  i = 0;i<n;i++){
			if(map.containsKey(arr[i]+k))
			{
				Pair p = new Pair(arr[i],arr[i]+k);
				map.put(arr[i],true);
				set.add(p);
			}
			if (map.containsKey(arr[i]-k))
			{
				Pair p = new Pair(arr[i],arr[i]-k);
				map.put(arr[i],true);
				set.add(p);
			}
			else
				map.put(arr[i],true);
		}
		return set.size();
	}
}


/*
Given an array of distinct elements, rearrange the elements of array in zig-zag fashion in O(n) time. The converted array should be in form a < b > c < d > e < f.The relative order of elements is same in the output i.e you have to iterate on the original array only.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N denoting the size of array.
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the array in Zig-Zag fashion.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 100
0 ≤A[i]<=10000

Example:
Input:
2
7
4 3 7 8 6 2 1
4
1 4 3 2
Output:
3 7 4 8 2 6 1
1 4 2 3
*/
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException{
        GFG g = new GFG();
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            g.arrangeInZigZagArray(arr,n);
            System.out.println();
            
        }
       
    }

    public void arrangeInZigZagArray(int arr[],int n){
        int i =0,j=1;
        boolean isAsc = true;
        int temp;
        while(j<n){
            if(isAsc){
                if(arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                isAsc = false;
            }
            else{
                if(arr[i]<arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                isAsc = true;
            }
            i++;
            j++;
        }

        for(i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

}

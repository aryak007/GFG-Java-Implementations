/*
Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.

Note: Left and right side elements can be equal to required element. And extreme elements cannot be required element.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated array elements.

Output:
For each test case, in a new line print the required element. If no such element present in array then print -1.

Constraints:
1<=T<=100
3<=N<=106
1<=A[i]<=106

Example:
Input:
3
4
4 2 5 7
3
11 9 12
6
4 3 2 7 8 9

Output:
5
-1
7
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
            g.findElement(arr,n);
            
        }
        //  int arr[] = {4,2,5,7};
        //  int n = 4;
        // g.findElement(arr,n);
    }

    public void findElement(int arr[],int n){
        int leftMax[] = new int[n];
        int rightMin[] = new int[n];
        int elem = -1;
        leftMax[0] = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1],arr[i-1]);
        }

        rightMin[n-1] = Integer.MAX_VALUE;

        for(int i=n-2;i>=0;i--){
            rightMin[i] = Math.min(rightMin[i+1],arr[i+1]);
        }

        for(int i = 1;i<n-1;i++){
            if(arr[i]>=leftMax[i] && arr[i]<=rightMin[i])
            {
                elem = arr[i];
                break;
            }
        }
        
        System.out.println(elem);
    }

}

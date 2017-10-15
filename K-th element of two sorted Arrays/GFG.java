/*
Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at the k’th position of the final sorted array.

Input:
First line consists of test cases T. First line of every test case consists of 3 integers N, M and K, denoting number of elements in array1, number of elements in array2 and K-th element respectively. Second and Third line of every test case consists of elements of Array1 and Array2 respectively.

Output:
Print the element at the Kth position.

Constraints:
1<=T<=200
1<=N,M<=1000
1<=Ai,Bi<=1000
1<=K<=N+M

Example:
Input:
1
5 4 5
2 3 6 7 9
1 4 8 10
Output:
6
*/
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException{
        GFG g = new GFG();
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int arr1[] = new int[n];
            int arr2[] = new int[m];
            st = new StringTokenizer(br.readLine().trim());
            for(int i = 0;i<n;i++){
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine().trim());
            for(int i = 0;i<m;i++){
                arr2[i] = Integer.parseInt(st.nextToken());
            }
            g.findKthElement(arr1,arr2,n,m,k);            
        }
    }
    void findKthElement(int arr1[],int arr2[],int n,int m,int k){
        int i =0,j=0,count=0;
        while(i<n && j<m){
            if(arr1[i]<arr2[j]){
                count++;
                if(count==k)
                {
                    System.out.println(arr1[i]);
                    break;
                }
                i++;
            }
            else if(arr1[i]==arr2[j]){
                count++;
                if(count==k)
                {
                    System.out.println(arr1[i]);
                    break;
                }
                count++;
                
                if(count==k)
                {
                    System.out.println(arr1[i]);
                    break;
                }
                i++;
                j++;
            }
            else
            {
                count++;
               
                if(count==k)
                {
                    System.out.println(arr2[j]);
                    break;
                }
                j++;
            }
        }
        if(j<m){
            while(j<m){
                count++;
                // System.out.println("Inside i=n-1"+count);
                if(count==k)
                {
                    System.out.println(arr2[j]);
                    break;
                }
                j++;
            }
        }
        if(i<n){
            while(i<n){
                count++;
                //System.out.println("Inside j=n-1"+count);
                if(count==k)
                {
                    System.out.println(arr1[i]);
                    break;
                }
                i++;
            }
        }

    }
}

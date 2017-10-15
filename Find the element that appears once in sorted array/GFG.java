/*
Given a sorted array of integers, every element appears twice except for one. Find that single one in linear time complexity and without using extra memory.

Input:

The first line of input consists number of the test cases. The description of T test cases is as follows:

The first line of each test case contains the size of the array, and the second line has the elements of the array.

 
Output:

In each separate line print the number that appears only once in the array.


Constraints:

1 ≤ T ≤ 70
1 ≤ N ≤ 100
0 ≤ A[i] ≤ 100000


Example:

Input:

1
11
1 1 2 2 3 3 4 50 50 65 65

Output:
4

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
            g.findElementInLogn(arr,n);

            //g.search(arr,0,n-1);
            
        }
        //int arr[] = {1, 1, 3, 3, 4, 5, 5, 7, 7};
        /*int arr[] = {1, 1, 3, 3, 4,4, 5, 5, 7, 7,8};
        g.search(arr,0,10);
        g.findElementInLogn(arr,11);*/
        
    }

    public void findElement(int arr[],int n){
        int ans = arr[0];
       for(int i=1;i<n;i++){
            ans = ans ^ arr[i];
       }
       System.out.println(ans);
    }

    public void findElementInLogn(int arr[],int n){
        int low = 0;
        int high = n-1;

        int mid;
        while(low<=high){

            if(low==high){
                System.out.println(arr[low]);
                break;
            }
            mid = (low + high)/2;

            //System.out.println(arr[mid]+ " "+mid);
            if((mid & 1)==0) //mid is even
            {
                if(arr[mid]==arr[mid+1])
                    low=mid+2;
                else
                    high = mid;
            }
            else{

                if(arr[mid]==arr[mid-1])
                    low=mid-2;
                else
                    high = mid-1;
            }
        }

    }

     public void search(int[] arr, int low, int high)
    {
        if(low > high)
            return;
        if(low == high)
        {
            System.out.println("The required element is "+arr[low]);
            return;
        }
         
        // Find the middle point
        int mid = (low + high)/2;
         
        // If mid is even and element next to mid is
        // same as mid, then output element lies on
        // right side, else on left side
        if(mid % 2 == 0)
        {
            if(arr[mid] == arr[mid+1])
                search(arr, mid+2, high);
            else
                search(arr, low, mid);
        }
        // If mid is odd
        else if(mid % 2 == 1)
        {
            if(arr[mid] == arr[mid-1])
                search(arr, mid-2, high);
            else
                search(arr, low, mid-1);
        }
    }
 

}

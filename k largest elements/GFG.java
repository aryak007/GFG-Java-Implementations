import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            String input[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int arr[] = new int[n];
            int k = Integer.parseInt(input[1]);
            String inputArr[] = br.readLine().trim().split(" ");
            for(int i =0;i<inputArr.length;i++)
                arr[i] = Integer.parseInt(inputArr[i]);
            buildMaxHeap(arr);
            printArray(arr);
            /*for(int i =0;i<k;i++){
                System.out.println(ExtractMax(arr,n-i));
                //printArray(arr);
            }*/

            for (int i=n-1; i>=0; i--)
            {
                // Move current root to end
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;        
                maxHeapify(arr, i, 0);
            }
            printArray(arr);
        }
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    static void buildMaxHeap(int arr[])
    {
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            maxHeapify(arr, n, i);
 
    }

    static int ExtractMax(int arr[],int n)
    {
        int max=arr[0];
        arr[0]=arr[n-1];
        maxHeapify(arr,n-1,0);
        return max;
    }

    static void maxHeapify(int arr[], int n, int i)
    {
        int largest = i; 
        int l = 2*i + 1;  
        int r = 2*i + 2;  
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largerst so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            maxHeapify(arr, n, largest);
        }
    }
}
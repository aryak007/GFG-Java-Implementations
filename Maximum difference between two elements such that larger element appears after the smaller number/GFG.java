/*
Given an array arr[] of integers, find out the difference between any two elements such that larger element appears after the smaller number in arr[].

Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)
*/

class GFG 
{
    
    int maxDiff(int arr[], int arr_size) 
    {
        int max_diff = arr[1] - arr[0];
        int min_element = arr[0];
        int i;
        for (i = 1; i < arr_size; i++) 
        {
            if (arr[i] - min_element > max_diff)
                max_diff = arr[i] - min_element;
            if (arr[i] < min_element)
                min_element = arr[i];
        }
        return max_diff;
    }

    /* Driver program to test above functions */
    public static void main(String[] args) 
    {
        MaximumDiffrence maxdif = new MaximumDiffrence();
        int arr[] = {1, 2, 90, 10, 110};
        int size = arr.length;
        System.out.println("MaximumDifference is " + maxdif.maxDiff(arr, size));
    }
}

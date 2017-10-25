import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        GFG g = new GFG();
        while (T-- > 0) {
            String input[] = br.readLine().trim().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int arr1[] = new int[m];
            int arr2[] = new int[n];
            int k = Integer.parseInt(input[1]);
            String inputArr[] = br.readLine().trim().split(" ");
            for (int i = 0; i < inputArr.length; i++)
                arr1[i] = Integer.parseInt(inputArr[i]);

            inputArr = br.readLine().trim().split(" ");
            for (int i = 0; i < inputArr.length; i++)
                arr2[i] = Integer.parseInt(inputArr[i]);
            System.out.println(g.printMergedArray(arr1, arr2));
        }
    }

    void printMergedArray(int arr1[],int arr2[]){
        int m = arr1.length;
        int n = arr2.length;
        int i = 0,j=0;
        while(i<m && j<n){
            if(arr[i]>=arr[j]){
                System.out.print(arr[i]+" ");
                i++;
            }
            else{
               System.out.print(arr[j]+" ");
                j++; 
            }
        }
        while(i<m){
            System.out.print(arr[i]+" ");
            i++;
        }
        while(j<n){
            System.out.print(arr[j]+" ");
            j++;
        }
    }
}
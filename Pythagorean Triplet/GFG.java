import java.io.*;
import java.util.*;

class GFG{
	public static void main(String args[]) throws IOException{
		GFG g = new GFG();
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0;i<n;i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			if(g.checkIfPythagoreanTripletPresent(arr,n)){
				System.out.println("Yes");
			}
			else
				System.out.println("No");
		}
	}

	public boolean checkIfPythagoreanTripletPresent(int arr[],int n){
		for(int i=0;i<n;i++){
			arr[i] = arr[i]*arr[i];
		}
		Arrays.sort(arr);
		int low =0,high = 0;

		boolean flag = false;
		for(int i = n-1;i>=0;i--){
			low = 0;
			high = i-1;
			while(low<high){
				if(arr[low]+arr[high]==arr[i])
				{
					flag = true;
					break;
				}
				else if(arr[low]+arr[high]<arr[i])
					low++;
				else
					high--;
			}
		}
		return flag;
	}
}


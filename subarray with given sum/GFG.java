import java.io.*;
import java.util.StringTokenizer;

class GFG{
	public static void main(String args[]) throws IOException{
		GFG g = new GFG();
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st1.nextToken());
			int s = Integer.parseInt(st1.nextToken());
			int arr[] = new int[n];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i = 0;i<n;i++){
				arr[i] = Integer.parseInt(st2.nextToken());
			}
			
			g.printSubarrayIndexes(arr,n,s);
		}
	}

	public void printSubarrayIndexes(int arr[],int n,int s){
		int l = 0;
		int r = 1;
		boolean flag = false;
		int curr_sum = arr[l];
		while(l<r && r<n){

			curr_sum = curr_sum+arr[r];

			while(curr_sum>s){
				curr_sum = curr_sum - arr[l];
				l++;
			}

			if(curr_sum==s)
			{
				System.out.println((l+1)+ " "+(r+1));
				flag = true;
				break;
			}
			

			if(curr_sum<s){
				r++;
			}
		}
		if(!flag)
			System.out.println("-1");
	}
}


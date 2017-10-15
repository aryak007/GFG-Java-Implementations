import java.io.*;
import java.util.StringTokenizer;

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
			
			System.out.println(g.calculateWater(arr,n));
		}
	}

	public int calculateWater(int arr[],int n){
		int left[] = new int[n];
		int right[] = new int[n];
		int water = 0;
		left[0] = arr[0];
		right[n-1] = arr[n-1];
		for(int i=1;i<n;i++){
			left[i] = Math.max(left[i-1],arr[i]);
		}
		for(int i=n-2;i>=0;i--){
			right[i] = Math.max(right[i+1],arr[i]);
		}

		for(int i=0;i<n;i++){
			water+= Math.max(Math.min(left[i],right[i])-arr[i],0);
		}
		return water;
	}
}


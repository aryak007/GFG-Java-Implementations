import java.io.*;
import java.util.*;
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
			
			g.printRequiredElements(arr,n);
			System.out.println();
		}
	}
	
	void printRequiredElements(int arr[],int n){
		HashMap<Integer,Boolean> nums = new HashMap<Integer,Boolean>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int no=0;
		nums.put(1,true);
		nums.put(2,true);
		nums.put(3,true);
		Arrays.sort(arr);
		for(int i = 0;i<n;i++){
			no = arr[i];
			while(no>0){
				if(!nums.containsKey(no%10))
					break;
				else{
					no /=10;
				}
			}
			if(no==0)
				result.add(arr[i]);
		}
		Collections.sort(result);
		Iterator<Integer> iterator = result.iterator();
		while(iterator.hasNext())
			System.out.print(iterator.next());

	}
}


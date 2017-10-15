import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    GFG g = new GFG();
	    while(t-->0){
	    	int n = Integer.parseInt(br.readLine());
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	int arr[] = new int[n];
	    	for(int i = 0;i<n;i++)
	    		arr[i] = Integer.parseInt(st.nextToken());
	    	g.findMinCost(arr,n)
	    }
	}
	public void findMinCost(int arr[],int n){
		int res = 0;
		PriorityQueue<Integer> minheap=new PriorityQueue<Integer>(1,new Comparator<Integer>() {
	        @Override
	        public int compare(Integer o1, Integer o2) {
	            return o1-o2;
	        }
	    });
		for(int i = 0;i<n;i++){
			minheap.add(arr[i]);
		}

		while(!minheap.isEmpty())){
			int x = minheap.remove();
			int y = minheap.remove();
			res = x+y;
		}
	}
}
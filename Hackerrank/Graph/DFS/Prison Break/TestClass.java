import java.io.*;
import java.util.ArrayList;
import java.lang.String;
import java.util.StringTokenizer;
import java.util.*;

class TestClass{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			//int N = Integer.parseInt(br.readLine());

			//int arr[] = new int[N];
			int T = Integer.parseInt(br.readLine());
			while(T-->0){
				int N = Integer.parseInt(br.readLine());
				Graph g = new Graph(N);
				int input[][] = new int[N][N];
				for(int i = 0;i<N;i++){
					StringTokenizer st = new StringTokenizer(br.readLine());
					for(int j=0;j<N;j++){
						input[i][j] = Integer.parseInt(st.nextToken());
					}
				}

				//Create adjacency lists
				for(int i = 0;i<N;i++){
					for(int j= 0;j<N;j++){
						if(input[i][j]==0)
							g.addEdge(i,j);
					}
				}
			System.out.println(g.countAllPaths(N));
			}
			
	}
}

class Graph{
	private int V;
	private LinkedList<Integer> adj[];
	private int count;

	Graph(int v){
		V = v;
		adj = new LinkedList[2*v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<Integer>();
	}

	void addEdge(int v, int w)
    {
        adj[v].add(w);
    }

 
    // A function used by DFS
    void countAllPathsUtil(int v,boolean visited[],LinkedList<Integer> pathCounts,int paths,int d)
    {
 		
        visited[v] = true;
        System.out.println("v "+v);
        if(v==d){
        	paths++;
        	pathCounts.add(paths);
        	System.out.println(paths+" --- ");
        	countAllPathsUtil(v,visited,pathCounts,paths,d);
        }

 	    else{
	 	    	Iterator<Integer> i = adj[v].listIterator();
		        while (i.hasNext())
		        {
		            int n = i.next();
		            if (!visited[n]){
		                countAllPathsUtil(n,visited,pathCounts,paths,d);
		            }
		        }
 	    } 
 	    visited[v] = false;
    }
 
    int countAllPaths(int N)
    {
    	int paths=0;
        boolean visited[] = new boolean[V];
        LinkedList<Integer> pathCounts = new LinkedList<Integer>();
        countAllPathsUtil(0, visited,pathCounts,paths,N-1);
        return pathCounts.size();
    }
}
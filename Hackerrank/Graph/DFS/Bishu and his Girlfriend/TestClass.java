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
			int N = Integer.parseInt(br.readLine());
			Graph g = new Graph(N);
			for(int i = 0;i<N-1;i++){
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st1.nextToken());
				int v = Integer.parseInt(st1.nextToken());
				g.addEdge(u-1,v-1);
			}
			int Q = Integer.parseInt(br.readLine());
			
			int minPathsSoFar = Integer.MAX_VALUE;
			int minX = Integer.MAX_VALUE;

			int visited[] = g.DFS();
			for(int i=0;i<N;i++){
				System.out.println(visited[i]+" ");
			}
			for(int i = 0;i<Q;i++){
				int x =Integer.parseInt(br.readLine());
				
				if(minPathsSoFar>visited[x-1]){
					minPathsSoFar = visited[x-1];
					minX = x;
				}

			}
			System.out.println(minX);
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
        adj[w].add(v);  // Add w to v's list.
    }

 
    // A function used by DFS
    void DFSUtil(int v,int visited[],int length)
    {
 		
        visited[v] = length;
        //System.out.print(v+" ");
 	    
 	    Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (visited[n]==0){
                DFSUtil(n,visited,length+1);
            }
        }
    }
 
    int[] DFS()
    {
        int visited[] = new int[V];
        DFSUtil(0, visited,1);
        return visited;
    }
}
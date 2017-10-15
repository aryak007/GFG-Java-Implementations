import java.io.*;
import java.util.ArrayList;
import java.lang.String;
import java.util.StringTokenizer;
import java.util.*;

class Solution{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                int cRoad = Integer.parseInt(st.nextToken());
                int cLib = Integer.parseInt(st.nextToken());
                Graph g = new Graph(n);
                for(int i = 0;i<m;i++){
                    st = new StringTokenizer(br.readLine());
                    int u = Integer.parseInt(st.nextToken());
                    int v = Integer.parseInt(st.nextToken());
                    g.addEdge(u-1,v-1);
                }
                g.DFS(n,cRoad,cLib);           
            }
        }  
}

class Graph
{
    private int V;  
    private LinkedList<Integer> adj[];
    private int count;
    private  boolean visited[];
    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        visited = new boolean[V];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<Integer>();
    }
 
    //Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
        adj[w].add(v);
    }
 
    // A function used by DFS
    void DFSUtil(int v,boolean visited[])
    {
        
        count++;
        visited[v] = true;
        
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n]){
                DFSUtil(n,visited);
            }
        }
    }
 
    void DFS(int n,int cRoad,int cLib)
    {
        long cost = 0;
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count = 0;
                DFSUtil(i, visited);
                cost = cost + cRoad;
                 if(cRoad > cLib)
                    cost = cost + (cLib*(count-1));
                else
                    cost = cost + (cRoad*(count-1));
                //cost = cost + Math.min(cRoad+(count-1)*cLib,cRoad*count);
            }
        }
        
        System.out.println(cost);
    }
 
}
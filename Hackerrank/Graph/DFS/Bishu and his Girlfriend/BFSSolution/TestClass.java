// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.
import java.io.*;
import java.util.*;
 
// This class represents a directed graph using adjacency list
// representation
class Graph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
    private int count;
 
    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
        count = 0;
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
 
    // prints BFS traversal from a given source s
    int BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
 
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();

            count++;
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return count;
    }
}


    class TestClass{

        // Driver method to
        public static void main(String args[]) throws IOException{
        
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
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
            for(int i = 0;i<Q;i++){
                int x =Integer.parseInt(br.readLine());
                int paths = g.BFS(x-1);
                System.out.println("paths"+paths);
                System.out.println("x "+x);

                if(minPathsSoFar>paths){
                    minPathsSoFar = paths;
                    minX = x;
                }
                if(minPathsSoFar==paths){
                    if(x<minX)
                    {
                        minPathsSoFar = paths;
                        minX = x;
                    }
                }

            }
            System.out.println(minX);
        }
    }
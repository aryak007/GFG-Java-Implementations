
class Graph{
	private int V;
	private LinkedList<Integer> adj[];
	private int count;

	Graph(int v)
    {
        V = v;
        count = 0;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<Integer>();
    }
 
    //Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
    }
 
    int DFSUtil(int v,boolean visited[])
    {
        visited[v] = true;
        //System.out.print(v+" ");
 	    
 	    Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n]){
            	count++;
                DFSUtil(n,visited);
            }
        }
    } 
    void DFS(int x)
    {
        boolean visited[] = new boolean[V];
        count = 0;
        if(visited[x]==false)
        	DFSUtil(x, visited);
        if(count>0)
            System.out.println(count);
    }
}

class 
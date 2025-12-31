class Solution {
    class Edge{
        int src, dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public void createGraph(int [][] connections, ArrayList<Edge> [] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int [] i: connections){
            int [] arr = i;
            int src = arr[0], dest = arr[1];
            graph[src].add(new Edge(src, dest));
            graph[dest].add(new Edge(dest, src));
        }
    }

    public void dfs(ArrayList<Edge> [] graph, int src, boolean [] visited){
        visited[src] = true;

        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);

            if(!visited[e.dest]){
                dfs(graph, e.dest, visited);
            }
        }
    }
    
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
    
        ArrayList<Edge> [] graph = new ArrayList[n];
        createGraph(connections, graph);

        int components = 0;
        boolean [] visited = new boolean[n];

        // Find the no. of components
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                dfs(graph, i, visited);
                components++;
            }
        }
        
        return components-1; 
    }
}
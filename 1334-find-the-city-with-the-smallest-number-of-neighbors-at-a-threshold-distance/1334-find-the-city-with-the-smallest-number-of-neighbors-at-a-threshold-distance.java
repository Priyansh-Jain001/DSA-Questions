class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // create an adjacency list
        List<List<int []>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int [] arr = edges[i];
            graph.get(arr[0]).add(new int[]{arr[0], arr[1], arr[2]});
            graph.get(arr[1]).add(new int[]{arr[1], arr[0], arr[2]});
        }

        int minReachable = Integer.MAX_VALUE;
        int resultCity = -1;

        // call dijkstras for every city and identify evry cities with dist<threshold
        for(int i=0; i<n; i++){
            int src = i;

            PriorityQueue<int []> q = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
            q.add(new int[]{src, 0});

            int [] dist = new int[n];
            boolean [] visited = new boolean[n];
            
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;


            while(!q.isEmpty()){
                int [] arr = q.remove();

                int node = arr[0], cost = arr[1];

                if(!visited[node]){
                    visited[node] = true;

                    for(int j=0; j<graph.get(node).size(); j++){
                        int u = graph.get(node).get(j)[0];
                        int v = graph.get(node).get(j)[1];
                        int wt = graph.get(node).get(j)[2];

                        // Relaxation Step
                        if(dist[u] + wt < dist[v]){
                            dist[v] = dist[u] + wt;
                            q.add(new int[]{v, dist[v]});
                        }
                    }
                }
            }

            // check dist of city < threshold
            int count = 0;
            for(int j=0; j<n; j++){
                if(j != src && dist[j] <= distanceThreshold){
                    count++;
                }
            }

            if(count <= minReachable){
                minReachable = count;
                resultCity = src;
            }
        }
        
        return resultCity;
    }
}
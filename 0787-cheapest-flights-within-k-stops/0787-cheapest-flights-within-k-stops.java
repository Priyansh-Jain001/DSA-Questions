class Solution {
    class Edge {
        int sr, des, wt;
        Edge(int sr, int des, int wt){
            this.sr = sr;
            this.des = des;
            this.wt = wt;
        }
    }

    class Pair {
        int node, stop, cost;
        Pair(int node, int stop, int cost){
            this.node = node;
            this.stop = stop;
            this.cost = cost;
        }
    }

    public void createGraph(int[][] flights, ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] arr : flights){
            int sr = arr[0];
            int dest = arr[1];
            int cost = arr[2];
            graph[sr].add(new Edge(sr, dest, cost));
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0, 0));

        while(!q.isEmpty()){
            Pair curr = q.remove();

            int sr = curr.node;
            int stop = curr.stop;
            int cost = curr.cost;

            if(stop > k) continue;

            for(Edge e : graph[sr]){
                int v = e.des;
                int wt = e.wt;

                if(cost + wt < dist[v]){
                    dist[v] = cost + wt;
                    q.add(new Pair(v, stop + 1, dist[v]));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}

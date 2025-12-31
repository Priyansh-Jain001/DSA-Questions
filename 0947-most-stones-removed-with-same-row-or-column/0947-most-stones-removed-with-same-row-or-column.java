class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean [] visited){
        visited[src] = true;

        for(int i=0; i<graph.get(src).size(); i++){
            if(!visited[graph.get(src).get(i)]){
                dfs(graph, graph.get(src).get(i), visited);
            }
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        boolean [] visited = new boolean[n];
        int components = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(graph, i, visited);
                components++;
            }
        }

        // total no. of removable stones
        return n-components;


    }
}
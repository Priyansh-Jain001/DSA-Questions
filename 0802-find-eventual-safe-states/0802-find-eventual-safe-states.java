class Solution {
    public boolean dfs(int [][] graph, int [] color, int src){
        if(color[src] != 0){
            return color[src] == 2; // safe node
        }

        // mark the node as visiting
        color[src] = 1;

        for(int i=0; i<graph[src].length; i++){
            int neigh = graph[src][i];
            if(!dfs(graph, color, neigh)){
                return false;
            }
        }

        // Mark ther node as safe
        color[src] = 2;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();

        int [] color = new int[graph.length];

        // Checking the cycle for all the nodes in the graph
        for(int i=0; i<graph.length; i++){
            if(dfs(graph, color, i)){
                ans.add(i);
            }
           
        }

        return ans;
    }
}
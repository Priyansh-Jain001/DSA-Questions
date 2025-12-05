class Solution {
    public boolean isBipartiteUtil(int [][] graph, int [] color, int a){
        Queue<Integer> q = new LinkedList<>();

        q.add(a);
        color[a] = 0; // 0 -> Yellow

        while(!q.isEmpty()){
            int curr = q.remove();

            for(int i=0; i<graph[curr].length; i++){
                int node = graph[curr][i];

                if(color[node] == -1){
                    int nextColor = color[curr] == 0?1: 0;
                    color[node] = nextColor;
                    q.add(node);
                }
                // neighbour is already colored(visited) and color of neighbour == color of curr -> return false
                else if(color[graph[curr][i]] == color[curr]){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int [] color = new int[graph.length];
        Arrays.fill(color, -1);

        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){
                if(!isBipartiteUtil(graph, color, i)){
                    return false;
                }
            }
           
    } return true;
}
}
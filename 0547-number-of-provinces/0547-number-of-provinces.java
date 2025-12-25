class Solution {

    public void dfs(int[][] isConnected, boolean [] visited, int city){
        visited[city] = true;
        
        for(int j=0; j<isConnected[city].length; j++){

            if(isConnected[city][j] == 1 && !visited[j]){
                dfs(isConnected, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean [] visited = new boolean[n];
        int province = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                province++;
            }
        }
        return province;
    }
}
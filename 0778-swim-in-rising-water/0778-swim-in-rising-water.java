class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean [][] visited = new boolean[n][n];

        int [] dir_x = {1, -1, 0, 0};
        int [] dir_y = {0, 0, 1, -1};

        PriorityQueue<int []> q = new PriorityQueue<>((a,b)->a[2]-b[2]);
        q.add(new int[]{0,0, grid[0][0]});
        
        int max = grid[0][0];
        int q_max = grid[0][0];
        
        while(!q.isEmpty()){
            int [] curr = q.remove();
            int x = curr[0], y = curr[1], val = curr[2];

            q_max = Math.max(q_max, val);

            if(x == n-1 &&  y == n-1){
               return Math.max(q_max, grid[n-1][n-1]);
            }

            if(!visited[x][y]){
                visited[x][y] = true;

                for(int d=0; d<4; d++){
                    int nx = x + dir_x[d];
                    int ny = y + dir_y[d];

                    if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny]){
                        if(grid[nx][ny]<=grid[x][y]){
                            q.add(new int[]{nx, ny, grid[nx][ny]});
                        }
                        else{
                            max = Math.max(grid[x][y], grid[nx][ny]);
                            q.add(new int[]{nx, ny, max});
                        }
                    }
                }

            }
        }
        

        return -1;
    }
}
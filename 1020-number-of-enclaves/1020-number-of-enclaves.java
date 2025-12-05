class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;

        Queue<int []> q = new LinkedList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    if(i == 0 || j == 0 || i == rows-1 || j == cols-1){
                        grid[i][j] = -1;
                        q.add(new int[]{i, j});
                    }
                    
                }
            }
        }

        boolean [][] visited = new boolean[rows][cols];

        int [] dx = {1, -1, 0, 0};
        int [] dy = {0, 0, 1, -1};
        
        while(!q.isEmpty()){
            int [] curr = q.remove();
            int x = curr[0], y = curr[1];

            visited[x][y] = true;

            for(int d=0; d<4; d++){
                int ndx = x + dx[d];
                int ndy = y + dy[d];

                if(ndx>=0 && ndy>=0 && ndx < rows && ndy < cols && !visited[ndx][ndy] && grid[ndx][ndy] == 1){
                    grid[ndx][ndy] = -1;
                    q.add(new int[]{ndx, ndy});
                    // break;
                }
            }
        }

        
            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    if(grid[i][j] == 1){
                        ans++;
                    }
                }
            }

        return ans;
    }
}
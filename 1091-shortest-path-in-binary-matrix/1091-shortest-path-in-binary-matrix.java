class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        // Base case
        if(grid[0][0] == 1 || grid[r-1][c-1] == 1) return -1;

        boolean [][] visited = new boolean[r][c];

        Queue<int []> q = new LinkedList<>();

        int [][] dir_8 = {{-1,-1} , {-1, 0}, {-1, 1},
                          {0, -1} ,          {0, 1},
                          {1, -1} , {1, 0} , {1, 1}
        };

        q.add(new int[]{0, 0, 1}); // add the 0,0 element with distance 1
        visited[0][0] = true;

        while(!q.isEmpty()){
            int [] curr = q.remove();

            int x = curr[0], y = curr[1], dist = curr[2];
            
            // Immediately return ditance when we are at the last cell(Destination found)
            if(x == r-1 && y == c-1){
                return dist;
            }

            // check in all the directions for 0      
            for(int [] d: dir_8){
                int ndx = x + d[0];
                int ndy = y + d[1];
                    
                if(ndx>=0 && ndy>=0 && ndx < r && ndy < c && !visited[ndx][ndy] && grid[ndx][ndy] == 0){
                    q.add(new int[]{ndx, ndy, dist+1});
                    visited[ndx][ndy] = true;
                }
            }
        }

        return -1; // No path found

    }
}
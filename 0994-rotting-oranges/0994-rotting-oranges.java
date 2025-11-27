class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int freshOrg = 0;

        Queue<int []> q = new LinkedList<>();

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    freshOrg++;
                }
            }
        }

        if(freshOrg == 0) return 0;

        int time = 0;
        int [] dir_x = {1, -1, 0, 0};
        int [] dir_y = {0, 0, 1, -1};



        while(!q.isEmpty()){
            int s = q.size(); // we need to take out all the rotten oranges
            boolean currRot = false;

            // Taking all the rotten from the queue ans using them to make the fresh rotten 
            for(int i=0; i<s; i++){
                int [] curr = q.remove();
                
                // storing the coordinates of the rotten orange currently taken out
                int x = curr[0];
                int y = curr[1];

                // checking all 4 directions around the rotten orange for the fresh oranges 
                for(int d = 0; d<4; d++){
                    int nx = x + dir_x[d];
                    int ny = y + dir_y[d];
                    
                    // checking if the fresh orange is present around the rotten one
                    if(nx>=0 && ny >= 0 && nx < rows && ny < cols && grid[nx][ny]==1){
                        grid[nx][ny] = 2; // rot the fresh
                        freshOrg--; // decrease the fresh count;
                        q.add(new int[]{nx, ny}); // add new rotten coordinates;
                        currRot = true;
                    }
                }
            }
            if(currRot) time++;
        }

        return freshOrg == 0?time: -1;

    }
}
class Solution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;

        Queue<int []> q = new LinkedList<>();
        boolean [][] visited = new boolean[n][m];

       // Mark the border zeros as safe (*)
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'O'){
                    if(i == 0 || j == 0 || i == n-1 || j == m-1){
                        board[i][j] = '*';
                        q.add(new int[]{i,j});
                    }
                }
            }
        }

        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        
        while(!q.isEmpty()){    
            int [] curr = q.remove();
            int x = curr[0], y = curr[1];
            visited[x][y] = true;

            for(int d = 0; d<4; d++){
                int nx = x+dx[d];
                int ny = y+dy[d];

                if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && board[nx][ny] == 'O'){
                    board[nx][ny] = '*';
                    // visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '*'){
                    board[i][j] = 'O';
                    }
            }
        }

    }
}
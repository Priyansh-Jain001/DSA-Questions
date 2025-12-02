class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int []> q = new LinkedList<>();
        
        int pixel = image[sr][sc];
        image[sr][sc] = color;
        q.add(new int[] {sr, sc});
        
        // Track whose color is changed
        boolean [][] visited = new boolean[image.length][image[0].length];
        visited[sr][sc] = true;

        int [] dx = {1,-1,0,0}; // move up and down
        int [] dy = {0,0,1,-1}; // move left and right

        while(!q.isEmpty()){
            int [] curr = q.remove();

            int x = curr[0], y = curr[1];
            visited[x][y] = true;

            for(int d=0 ; d<4; d++){
                int nx = x+dx[d]; // new x co-ordinate to check for
                int ny = y+dy[d]; // new y co-ordinate to check for

                if(nx>=0 && ny>=0 && nx<image.length && ny<image[0].length && image[nx][ny] == pixel && !visited[nx][ny]){
                    image[nx][ny] = color;
                    
                    q.add(new int[] {nx, ny});
                }
            }
        }

        return image;
    }
}
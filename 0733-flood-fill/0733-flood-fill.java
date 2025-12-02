class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int []> q = new LinkedList<>();
        
        int pixel = image[sr][sc];
        image[sr][sc] = color;
        q.add(new int[] {sr, sc});
        
        boolean [][] visited = new boolean[image.length][image[0].length];
        visited[sr][sc] = true;

        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};

        while(!q.isEmpty()){
            int [] curr = q.remove();

            int x = curr[0], y = curr[1];

            for(int d=0 ; d<4; d++){
                int nx = x+dx[d];
                int ny = y+dy[d];



                if(nx>=0 && ny>=0 && nx<image.length && ny<image[0].length && image[nx][ny] == pixel && !visited[nx][ny]){
                    image[nx][ny] = color;
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }

        return image;
    }
}
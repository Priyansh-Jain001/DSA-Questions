class Solution {
    public int[][] transpose(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int [][] transpose = new int[c][r];
        for(int i=0; i<transpose.length; i++){
            for(int j=0; j<transpose[i].length; j++){
                transpose[i][j] = matrix[j][i];
                    
            }
        }

        return transpose;
    }
}
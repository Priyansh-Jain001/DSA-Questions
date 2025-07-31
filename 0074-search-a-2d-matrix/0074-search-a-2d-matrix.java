class Solution {
    /* one way
    public boolean searchMatrix(int[][] matrix, int target) {
        int row_st = 0, row_end = matrix.length-1;
        // int col_st = 0, col_end = matrix[]

        while(row_st<=row_end){
            int mid_row = row_st + (row_end-row_st)/2;
            int col_st = 0, col_end = matrix[mid_row].length-1;


            if(matrix[mid_row][col_st] > target){
                row_end = mid_row - 1;
            }
            else if(matrix[mid_row][col_end] < target){
                row_st = mid_row + 1;
            }
            else{
                while(col_st <= col_end){
                    int mid_col = col_st + (col_end-col_st)/2;

                    if(matrix[mid_row][mid_col] == target){
                        return true;
                    }
                    else if(matrix[mid_row][mid_col] < target){
                        col_st = mid_col + 1;
                    }else{
                        col_end = mid_col - 1;
                    }
                }
            }  
        }

        return false;
    }
    */
    
    // Treat the 2D matrix ad 1D
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int st = 0, end = m*n-1;

        while(st <= end){
            int mid = st +(end-st)/2;
            int midValue = matrix[mid/n][mid%n];

            if(midValue == target){
                return true;
            }else if(midValue < target){
                st = mid+1;
            }else{
                end = mid-1;
            }
        }

        return false;
    }

}
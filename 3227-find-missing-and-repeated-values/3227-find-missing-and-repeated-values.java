class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length*grid.length;
        HashSet<Integer> set = new HashSet<>();
        int [] ans = new int[2];

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(set.contains(grid[i][j])){
                    ans[0] = grid[i][j];
                }else{
                    set.add(grid[i][j]);
                }
            }
        }

        int sum = n*(n+1)/2;
        int set_sum = 0;

        for(int i: set){
            set_sum += i;
        }

        // Set always contains unique element

        ans[1] = sum-set_sum;

        return ans;
    }
}
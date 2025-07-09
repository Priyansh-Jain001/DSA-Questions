class Solution {
    public boolean canJump(int[] nums) {
        // reacheble is the index where we reach (initially its 0)
        int reachable = 0;

        for(int i=0; i<nums.length; i++){
            if(i > reachable){  // current_id > reachable_idx which is not possible
                return false;
            }

            reachable = Math.max(reachable, i+nums[i]);
        }

        return true;   
    }
}
class Solution {
    public int findKthPositive(int[] nums, int k) {
        int missingCount = 0;
        int curr = 1;
        int i = 0;

        while(true){
            if(i<nums.length && nums[i] == curr){
                i++; 
            }else{
                missingCount++;
                if(missingCount == k) return curr;
            }

            curr++;
        }
    }
}
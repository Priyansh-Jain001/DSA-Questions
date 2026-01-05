class Solution {
    public int findKthPositive(int[] nums, int k) {
        
        /* Brute-Force Approach
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
        */

        // Binary-Search Approach
        int low = 0, high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            int missing = nums[mid] - (mid+1);

            if(missing < k){  // more elements missing on the right side
                low = mid+1;
            }
            else{  // elements will be missing on the left side
                high = mid - 1;
            }
        }

        return low + k;
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }

        int ans = 0; // Store the final ans
        for(int i: set){ // set only contains one value
            ans = i;
        }

        return ans;
    }
}

// Since every elements appears twice then after traversing all the array only one element will remain in the set.
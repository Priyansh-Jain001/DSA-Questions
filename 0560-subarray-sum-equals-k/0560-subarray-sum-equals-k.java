class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;

        int [] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                if(i != 0 && (prefix[j] - prefix[i-1]) == k){
                    ans++;
                }
                else if(i == 0 && prefix[j] == k){
                    ans++;
                }
            }
        }

        return ans;
    }
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++){
            q.add(nums[i]);
        }

        int ans = 0;
        for(int i=0; i<=nums.length-k; i++){
            ans = q.remove();
        }

        return ans;

        
    }
}
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        // Arrays.sort(nums);
        
        int max = Integer.MIN_VALUE;
        for(int i: nums){
            max = Math.max(i, max);
        }  
        
        int st = 1, end = max, ans = -1;

        while(st <= end){
            int mid = st + (end - st)/2;
            int sum = 0;

            for(int i: nums){
                sum = sum + (int)Math.ceil((double)i/(double)mid);
            }

            if(sum > threshold) st = mid+1;
            else{
                ans = mid;
                end = mid - 1;  
            } 
        }
        return ans;
    }
}
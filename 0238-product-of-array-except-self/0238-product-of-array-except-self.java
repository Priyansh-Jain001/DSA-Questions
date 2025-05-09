class Solution {

    // Brute force TC=O(n^2) will hit TLE fo large test cases
    /*
    public int[] productExceptSelf(int[] nums) {
        int [] ans = new int[nums.length];
        int result = 1;

        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(j == i){
                    continue;
                }else{
                    result *= nums[j];
                }
            }

            ans[i] = result;
            result = 1;
            
        }

        return ans;
    }
    */

    // Better Approach TC=O(n)
    public int[] productExceptSelf(int[] nums){
        int [] ans = new int[nums.length];
        ans[0] = 1;

        // Build an array where each element is the product of all elements to the left of the current index.
        for(int i=1; i<nums.length; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        int rightProduct = 1;

        for(int i=nums.length-1; i>=0; i--){
            ans[i] = ans[i] * rightProduct;
            rightProduct *= nums[i];
        }
        
        return ans;
    }
}
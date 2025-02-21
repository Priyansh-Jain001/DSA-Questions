class Solution {
    public int search(int[] nums, int target) {
        int st =0, end = nums.length-1;
        
        while(st<=end){
            int mid = st + (end-st)/2;
            if(target == nums[mid]){
              return mid;  
            } 
            else if(target < nums[mid]){
                end = mid-1;
            }else{
                st = mid+1;
            }
        }
        return -1;

    }
}
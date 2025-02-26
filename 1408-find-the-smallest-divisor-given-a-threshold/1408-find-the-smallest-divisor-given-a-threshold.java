class Solution {
    // public int smallestDivisor(int[] nums, int threshold) {
        
    //     int max = Integer.MIN_VALUE;
    //     for(int i: nums){
    //         max = Math.max(i, max);
    //     }  
        
    //     int st = 1, end = max, ans = -1;

    //     while(st <= end){
    //         int mid = st + (end - st)/2;
    //         int sum = 0;

    //         for(int i: nums){
    //             sum = sum + (int)Math.ceil((double)i/(double)mid);
    //         }

    //         if(sum > threshold) st = mid+1;
    //         else{
    //             ans = mid;
    //             end = mid - 1;  
    //         } 
    //     }
    //     return ans;
    // }

    public int sumByD(int[] arr, int div) {
        int n = arr.length; //size of array
        //Find the summation of division values:
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double)(arr[i]) / (double)(div));
        }
        return sum;
    }
    public int smallestDivisor(int[] arr, int limit) {
        int n = arr.length; //size of array.
        if(n > limit) return -1;
        //Find the maximum element:
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        int low = 1, high = maxi;

        //Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sumByD(arr, mid) <= limit) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
      return low;
    }
}
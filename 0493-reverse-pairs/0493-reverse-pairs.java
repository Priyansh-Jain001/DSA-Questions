class Solution {
    public int mergeSort(int [] nums, int left, int right){
        if(left >= right) return 0;

        int mid = left + (right-left)/2;

        int count = 0;

        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid+1, right);

        count += crossPairs(nums, left, mid, right);

        merge(nums, left, mid, right);

        return count;
    }

    public int crossPairs(int [] nums, int left, int mid, int right){
        int count = 0;
        int j = mid+1;

        for(int i=left; i <= mid; i++){
            while (j <= right && (long) nums[i] > 2L * nums[j]){
                j++;
            }
            count += (j-(mid+1));
        }

        return count;
    }

    public void merge(int [] nums, int st, int mid, int end){
        int n = mid - st + 1;
        int m = end - mid;

        int [] left = new int[n];
        int [] right = new int[m];

        for(int i=0; i<n; i++){
            left[i] = nums[st+i];
        }

        for(int j=0; j<m; j++){
            right[j] = nums[mid+1+j];
        }

        int i=0, j=0, k = st;

        while(i<n && j<m){
            if(left[i] <= right[j]){
                nums[k++] = left[i++];
            }else{
                nums[k++] = right[j++];
            }
        }

        while(i<n) nums[k++] = left[i++];
        while(j<m) nums[k++] = right[j++];
    }
    public int reversePairs(int[] nums) {
        
        /* Brute-Force Approach
        int count = 0;
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] > 2 * nums[j]){
                    count++;
                }
            }
        }
        return count;
        */

        int ans = mergeSort(nums, 0, nums.length-1);
        return ans;
    }
}
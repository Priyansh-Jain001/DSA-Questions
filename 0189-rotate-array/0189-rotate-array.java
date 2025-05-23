class Solution {
    public void reverse(int [] arr, int i, int j){
        while(i<j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;

        reverse(nums, 0, n-k-1); // reverse the left-part 
        reverse(nums,n-k, n-1);  // reverse the right-part
        reverse(nums, 0, n-1);   // reverese the full array now
    }
}
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int waterTrapped = 0;

        int l=0, r=height.length-1;
        int leftMax = 0, rightMax = 0;
        while(l<r){
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);

            if(leftMax<rightMax){
                waterTrapped += leftMax-height[l]; 
                l++;
            }else{
                waterTrapped += rightMax - height[r];
                r--;
            }
        }

        return waterTrapped;
    }
}
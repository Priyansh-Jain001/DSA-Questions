class Solution {
    public boolean check(int[] nums) {
        // int [] arr = new int[nums.length];
        // int x= 0;
        // boolean flag = true;

        // while(x<nums.length){
        //     // filling the elements from the nums to arr
        //     for(int i=0; i<nums.length; i++){
        //         arr[i] = nums[(i+x)% nums.length];
        //     }

        //     // checking if the arr is sorted or not
        //     for(int i=1; i<arr.length; i++){
        //         if(arr[i]<arr[i-1]){
        //             flag = false;
        //             break;
        //         }
        //     }

        //     if(flag == true){
        //         return true;
        //     }else{
        //         flag = true;
        //     }
        //     x++;
        // }
        // return false;

        int count = 0;
        for(int i=0 ; i<nums.length; i++){
            if(nums[i] > nums[(i+1) % nums.length]){
                count++;
            }
        }

        if(count >1){
            return false;
        }else{
            return true;
        }
        }
        
    }

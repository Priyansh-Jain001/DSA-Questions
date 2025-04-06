class Solution {
    public boolean containsDuplicate(int[] arr) {
        
        // Brute Force Approach
        // for(int i=0; i<arr.length; i++){
        //     for(int j= i + 1; j<arr.length; j++){
        //         if(arr[i] == arr[j]){
        //             return true;
        //         }
        //     }
        // }

        // return false;

        // Better Approach Approach
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                return true;
            }else{
                map.put(arr[i], i);
            }
        }

        return false;
    }
}
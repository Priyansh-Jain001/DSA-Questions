class Solution {
    public int maxPile(int [] piles){
        int max = Integer.MIN_VALUE;

        for(int i: piles){
            max = Math.max(max, i);
        }
        return max;
    }

    public int totalHours(int [] piles, int hourly){
        int ans = 0;
        for(int i=0;i<piles.length; i++){
            // Compute hours needed for this (i) pile
            ans += Math.ceil((double)piles[i]/hourly) ;   
        }

        // Return total hours needed to finish all piles
        return ans;
    }

    // public int minEatingSpeed(int[] piles, int h) {
    //     int max = maxPile(piles);

    //     for(int i=1; i<=max; i++){  // Try all speeds from 1 to max
    //         int requiredTime = totalHours(piles, i);   // Calculate time needed for speed i
    //         if(requiredTime <= h){   // If she can finish within h hours
    //             return i;  // Return the minimum valid speed
    //         }
    //     }

    //     return max;  // If no smaller speed worked, return max
    // }

    //Optimal Approach
    public int minEatingSpeed(int[] piles, int h){
        int st= 1, end = maxPile(piles), ans = -1;

        while(st <= end){
            int mid = st + (end - st)/2;

            int requiredTime = totalHours(piles, mid);

            if(requiredTime > h) st = mid + 1;
            else{
                ans = mid;
                end = mid -1;
            }
        }
        return ans;
    }
}
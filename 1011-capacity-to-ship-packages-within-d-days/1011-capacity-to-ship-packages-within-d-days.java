class Solution {

    // Check feasibility: Can we ship within 'days' using capacity 'cap'?
    public boolean canShip(int [] weights, int days, int capacity){
        int currLoad = 0;
        int daysUsed = 1;

        for(int w: weights){
            // ship cannot take more — start next day
            if(currLoad + w > capacity){
                daysUsed++;
                currLoad = 0;
            }

            currLoad += w ;

            if(daysUsed > days) return false;
        }

        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for(int i: weights){
            low = Math.max(low, i);
            high += i;
        }

        while(low < high){
            int mid = low + (high - low)/2;

            if(canShip(weights, days, mid)){
                high = mid;  // check for the smaller weights
            }
            else{
                low = mid+1; // need larger capacity 
            }
        }

        return low;

    }
}
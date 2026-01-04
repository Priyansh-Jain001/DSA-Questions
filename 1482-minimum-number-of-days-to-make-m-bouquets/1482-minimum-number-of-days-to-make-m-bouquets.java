class Solution {
    public boolean canMake(int [] bloomDay, int m, int k, int day){
        int bouquets = 0;
        int count = 0;  // counts the consecutive flowers

        for(int d: bloomDay){
            if(d <= day){  // flower bloomed
                count++;

                if(count == k){
                    bouquets++;
                    count = 0;   // reset because each flower used once
                }
            }
            else{
                count = 0;  // break adjacency
            }

            if(bouquets >= m){
                return true;
            }
        }

        return false;

    }
    public int minDays(int[] bloomDay, int m, int k) {
        int size = bloomDay.length;
        if(size < (long) m*k) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i: bloomDay){
            low = Math.min(low, i);
            high = Math.max(high, i);
        }

        while(low < high){
            int mid = low + (high - low)/2;

            if(canMake(bloomDay, m, k, mid)){
                high = mid;
            }else{
                low = mid+1;  // requires more day to make bouque
            }
        }

        return low;
    }
}
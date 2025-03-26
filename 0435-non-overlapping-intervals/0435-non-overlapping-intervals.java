class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingDouble( o -> o[1])); // Sorting according to the end time in the ascending order

        int count = 1;
        int lastPosition = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] >= lastPosition){
                count += 1;
                lastPosition = intervals[i][1];
            }
        }

        int ans = intervals.length-count;
        return ans;


    }
}
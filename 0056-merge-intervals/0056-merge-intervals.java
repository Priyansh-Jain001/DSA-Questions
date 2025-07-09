class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int []> list = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        int j = 0;
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }
            else{
                list.add(new int[]{start, end});

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        list.add(new int[]{start, end});

        return list.toArray(new int[list.size()][]);

        
    }
}
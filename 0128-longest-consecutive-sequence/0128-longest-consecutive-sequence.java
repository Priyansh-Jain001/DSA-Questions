class Solution {
    public int longestConsecutive(int[] nums) {
        
        /* TC = O(n^2)
        int count = 0, x = 0;
        int max = 0;

        if(nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();

        for(int i: nums){
            set.add(i);
        }

        for(int i: set){
            if(set.contains(i-1)){
                count = 1;
                x = i;

                while(set.contains(x+1)){
                    count += 1;
                    x = x+1;
                }

                max = Math.max(max, count);
            }  
        }
        return max+1;
        */

        /* Approach2 TC = O(n logn), SC = O(n)
        int count =0, max = 0;

        if(nums.length == 0) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i: nums){
            set.add(i);
        }

        for(int i: set){
            pq.add(i);
        }

        int x = pq.poll();

        for(int i=0; i<set.size()-1; i++){
            if(pq.peek() - x == 1){
                count += 1;
                x = pq.poll();
            }else{
                count = 0;
                x = pq.poll();
            }

            max = Math.max(max, count);
        }

        return max+1;
        */

    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) set.add(num);

    int longest = 0;

    for (int num : set) {
        // only start counting when num is the beginning of a sequence
        if (!set.contains(num - 1)) {
            int current = num;
            int count = 1;

            while (set.contains(current + 1)) {
                current++;
                count++;
            }

            longest = Math.max(longest, count);
        }
    }

        return longest;
    }

}

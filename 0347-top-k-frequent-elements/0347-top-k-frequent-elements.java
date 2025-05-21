class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count the frequency of every element
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        // Step 2: Use a min-heap to store top k frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>( (a, b) -> a.getValue() - b.getValue() );

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.add(entry);

            if(pq.size() > k){
                pq.poll(); // remove the element with the least frequency(highest priority)
            }
        }

        int [] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = pq.poll().getKey();
        }

        return ans;
    }
}
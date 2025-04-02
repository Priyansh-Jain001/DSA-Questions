class Solution {
    public String frequencySort(String s) {
        // TreeMap<Character, Integer> map = new TreeMap<>();

        // for(int i=0; i<s.length(); i++){
        //     char c = s.charAt(i);

        //     if(map.get(c))
        // }
        ArrayList<Character> list = new ArrayList<>();

        for(int i=0;i<s.length(); i++){
            list.add(s.charAt(i));
        }

        TreeMap<Character, Integer> map = new TreeMap<>();
        for(char c: list){
            map.put(c, map.getOrDefault(c, 0) + 1);;
            
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)-> map.get(b) - map.get(a));

        maxHeap.addAll(map.keySet());

        StringBuilder ans = new StringBuilder();
        while(!maxHeap.isEmpty()){
            char ch = maxHeap.poll();
            ans.append(String.valueOf(ch).repeat(map.get(ch)));
        }

        return ans.toString();
        


    }
}
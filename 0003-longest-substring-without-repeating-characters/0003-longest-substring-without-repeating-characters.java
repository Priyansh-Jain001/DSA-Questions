class Solution {
    public int lengthOfLongestSubstring(String s) {
        /* The code given below will work on sub-sequence not on substring
        HashSet<Character> set = new HashSet<>();
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
            }
        }

        return set.size();
        */

       int left = 0, right = 0, maxLength = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);

            // If character is not in set, add it and move right pointer
            if (!set.contains(c)) {
                set.add(c);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                // If character is duplicate, remove from left side
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }
}
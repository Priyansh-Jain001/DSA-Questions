import java.util.*;

public class Solution {
    public int romanToInt(String s) {
        // Step 1: Define Roman numeral values
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;
        int prevValue = 0;  // To keep track of previous numeral value

        // Step 2: Iterate from RIGHT to LEFT
        for (int i = s.length() - 1; i >= 0; i--) {
            int currValue = map.get(s.charAt(i));

            // Step 3: If the previous value is greater, subtract current value
            if (currValue < prevValue) {
                ans -= currValue;
            } else {
                ans += currValue;
            }

            prevValue = currValue; // Update previous value
        }

        return ans;
    }
}

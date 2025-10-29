// 

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = s.length();

        // Check sign
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sb.append(s.charAt(i));
            i++;
        }

        // First character after sign must be a digit
        if (i >= n || !Character.isDigit(s.charAt(i))) {
            return 0;
        }

        // Collect digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            sb.append(s.charAt(i));
            i++;
        }

        long ans = 0;
        try {
            ans = Long.parseLong(sb.toString());
        } catch (NumberFormatException e) {
            return s.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        // Clamp to int range
        if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) ans;
    }
}

public class Solution {
    // public boolean isPowerOfThree(int n) {
    //     int maxPowerOf3 = 1162261467; // 3^19 is the largest power of 3 in int range
    //     return n > 0 && maxPowerOf3 % n == 0;
    // }

    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
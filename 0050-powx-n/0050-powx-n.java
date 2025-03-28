class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;  // Base case: x^0 = 1
        
        // Handle negative exponent safely (avoid overflow)
        long exp = n;  // Convert to long to prevent overflow
        if (n < 0) {
            x = 1 / x;
            exp = -exp;
        }

        double result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {  // If exponent is odd, multiply result by x
                result *= x;
            }
            x *= x;  // Square x
            exp /= 2;  // Reduce exponent by half
        }

        return result;
    }
}

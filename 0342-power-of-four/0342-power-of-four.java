class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==1) return true;

        float num = (float)n;
        while(num != 4){
            num = num/4;
            if(num == 0){
                return false;
            }
        }
        return true;
    }
}
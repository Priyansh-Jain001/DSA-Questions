class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // Sort greed factors
        Arrays.sort(s); // Sort cookie sizes

        int child = 0, cookie = 0;

        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                child++; // This child is content
            }
            cookie++; // Move to the next cookie regardless
        }

        return child; // Number of content children
    }
}

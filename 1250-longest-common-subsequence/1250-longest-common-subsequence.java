class Solution {
    public int lcs(String s1, String s2, int n, int m){
        // Base Case
        // if(n == 0 || m == 0){
        //     return 0;
        // }

        // if(s1.charAt(n-1) == s2.charAt(m-1)){ 
        //     return 1 + lcs(s1, s2, n-1, m-1);
        // }
        // else{ // characters at last position not same
        //     int ans1 = lcs(s1, s2, n-1, m);
        //     int ans2 = lcs(s1, s2, n, m-1);

        //     return Math.max(ans1, ans2);
        // }

        int [][] arr = new int[n+1][m+1];

        for(int i=0; i<arr.length; i++){
            arr[i][0] = 0;
        }

        for(int j=0; j<arr[0].length; j++){
            arr[0][j] = 0;
        }

        for(int i=1; i<arr.length; i++){
            for(int j=1; j<arr[i].length; j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    arr[i][j] = 1 + arr[i-1][j-1];
                }else{
                    int ans1 = arr[i-1][j];
                    int ans2 = arr[i][j-1];

                    arr[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return arr[n][m];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, text1.length(), text2.length());
    }
}
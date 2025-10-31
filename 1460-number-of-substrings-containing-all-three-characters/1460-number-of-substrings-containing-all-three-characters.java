class Solution {
    /* Time limit exceeds for large cases
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int n = s.length();

        for(int i=0; i<n-2; i++){
            for(int j=i+2; j<n; j++){
                String str = s.substring(i, j+1);
                if(str.contains("a") && str.contains("b") && str.contains("c")){
                    ans++;
                }
            }
        }

        return ans;
    }
    */

    /*
        public int numberOfSubstrings(String s) {
        int ans = 0;
        int n = s.length();

        for(int i=0; i<n-2; i++){
            int sum = 0;
            for(int j=i+2; j<n; j++){
                String str = s.substring(i, j+1);
                if(str.contains("a") && str.contains("b") && str.contains("c")){
                    sum = n-j;
                    break;
                }
            }
            ans += sum;
        }

        return ans;
    }

    */

    public int numberOfSubstrings(String s){
        int left = 0;
        int count = 0;
        int [] charr = new int[3];

        for(int right = 0; right<s.length(); right++){
            charr[s.charAt(right) - 'a']++;

            while(charr[0]>0 && charr[1]>0 && charr[2]>0){
                count += s.length() - right;
                charr[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return count;
    }

}
class Solution {

    private boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
            
        }

        return true;
    }

    public String longestPalindrome(String s) {
        int max = Integer.MIN_VALUE;
        StringBuilder ans = new StringBuilder("");
        int n = s.length();

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                String str = s.substring(i, j+1);
                if(isPalindrome(str)){
                    if(max < str.length()){
                        max = Math.max(max, str.length());
                        ans = new StringBuilder(str);
                    }
                    
                }
            }
        }

        return ans.toString();
    }
}
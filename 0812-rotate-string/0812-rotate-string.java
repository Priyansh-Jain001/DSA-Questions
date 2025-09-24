class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)) return true;
        
        StringBuffer sb = new StringBuffer("");

        for(int i=1; i<s.length(); i++){
            String rotated = s.substring(i, s.length()) + s.substring(0, i);

            if(rotated.equals(goal)){
                return true;
            }

        }

        return false;
    }
}
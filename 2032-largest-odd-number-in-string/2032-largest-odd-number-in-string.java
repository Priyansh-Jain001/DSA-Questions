class Solution {

    // static String func(String s, int idx, String ans, ArrayList<Long> list){
    //     if(idx == s.length()){
    //         if(ans == ""){
    //             list.add(0L);
    //         }else{
    //            list.add(Long.parseLong(ans)); // Convert the string into the integer 
    //         }
            
    //         return ans; 
    //     }

    //     // part of subset
    //     func(s, idx+1, ans+s.charAt(idx), list);

    //     // Not a part of subset
    //     func(s, idx+1, ans, list);

    //     Collections.sort(list, (a,b)-> Long.compare(b,a));

    //     for(long i: list){
    //         if(i%2 != 0){  // Odd value
    //             return String.valueOf(i);
    //         }
    //     }

    //     return "";
    // }


    public String largestOddNumber(String num) {
        // ArrayList<Long> list = new ArrayList<>();
        // String ans = func(num, 0, "", list);
        // int ans = -1;

// Start traversing from the back and return the string from 0 to the idx i where you first got the odd value

        for(int i = num.length() - 1; i>=0; i--){
            int n = Integer.parseInt(Character.toString(num.charAt(i)));
            if(n%2 != 0){
                // ans = i;
                return num.substring(0, i+1);
                // break;
            }
        }

        // return num.substring(0, ans+1);
        return "";
    }
}
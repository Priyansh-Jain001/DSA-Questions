class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String [] s_arr = s.split(" ");
        Stack<String> stack = new Stack<>();
        StringBuilder str = new StringBuilder();

        // for(int i=s_arr.length-1; i>=0; i--){
        //     if(i == 0){
        //         str.append(s_arr[i]); 
        //     }else{
        //         str.append(s_arr[i]+ " ");
        //     }
                   
        // }

        for(int i=0; i<s_arr.length; i++){
            if(s_arr[i] != ""){
                if(i==0){
                    stack.push(s_arr[i]);
                }else{
                   stack.push(s_arr[i] + " "); 
                }
                
            }
        }

        while(!stack.isEmpty()){
            str.append(stack.pop());
        }

        return str.toString();
    }
}
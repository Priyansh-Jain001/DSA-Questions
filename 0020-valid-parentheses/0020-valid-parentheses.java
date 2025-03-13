class Solution {
    public boolean isValid(String s) {
        char [] arr = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for(char ele: arr){
            if(ele == '(' || ele == '[' || ele == '{'){
                stack.push(ele);
                continue;
            }

            else if(stack.isEmpty()) return false;

            char top = stack.pop();

            if(top == '(' && ele != ')') return false;
            if(top == '[' && ele != ']') return false;
            if(top == '{' && ele != '}') return false;
        }

        return (stack.isEmpty() == true);
    }
}
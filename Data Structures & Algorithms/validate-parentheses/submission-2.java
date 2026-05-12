class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if((ch-'A'>=0 && ch-'Z'<=0)
            || (ch-'a'>=0 && ch-'z'<=0)
            || (ch-'0'>=0 && ch-'9'<=0))
                continue;
            else if(ch=='(' || ch=='{' || ch=='[')
                stack.push(ch);
            else {
                if((ch==')' && (stack.isEmpty() || stack.peek()!='('))
                || (ch=='}' && (stack.isEmpty() || stack.peek()!='{'))
                || (ch==']' && (stack.isEmpty() || stack.peek()!='[')))
                    return false;
                if(!stack.isEmpty())
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

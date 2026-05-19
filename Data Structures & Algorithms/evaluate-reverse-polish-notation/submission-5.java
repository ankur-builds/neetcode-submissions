class Solution {
    public int checkOperator(String token){
        if(token.equals("+"))
            return 1;
        else if (token.equals("-"))
            return 2;
        else if (token.equals("*"))
            return 3;
        else if (token.equals("/"))
            return 4;
        else
            return -1;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            switch(checkOperator(token)){
                case 1 : 
                    stack.push(stack.pop() + stack.pop());
                    break;
                case 2 :
                    int a = stack.pop();
                    int b = stack.pop(); 
                    stack.push(b-a);
                    break;
                case 3 :
                    stack.push(stack.pop() * stack.pop());
                    break;
                case 4 :
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y/x);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
}

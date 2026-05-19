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

        int value = 0;
        for(String token : tokens){
            switch(checkOperator(token)){
                case 1 : 
                    value = stack.pop() + stack.pop();
                    stack.push(value);
                    break;
                case 2 :
                    value = -(stack.pop() - stack.pop());
                    stack.push(value);
                    break;
                case 3 :
                    value = stack.pop() * stack.pop();
                    stack.push(value);
                    break;
                case 4 :
                    int x = stack.pop();
                    int y = stack.pop();
                    y = (y==0) ? 1 : y; 
                    value = y / x;
                    stack.push(value);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
}

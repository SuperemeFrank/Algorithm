class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<String> stack = new Stack<>();
        for (String i : tokens) {
            int x = 0;
            int y = 0;
            if (i.equals("*")) {
                x = Integer.valueOf(stack.pop());
                y = Integer.valueOf(stack.pop());
                stack.push((x * y) + "");
            } else if (i.equals("+")) {
                x = Integer.valueOf(stack.pop());
                y = Integer.valueOf(stack.pop());
                stack.push((x + y) + "");
            } else if (i.equals("/")) {
                x = Integer.valueOf(stack.pop());
                y = Integer.valueOf(stack.pop());
                stack.push((y / x) + "");
            } else if (i.equals("-")) {
                x = Integer.valueOf(stack.pop());
                y = Integer.valueOf(stack.pop());
                stack.push((y - x) + "");
            } else {
                stack.push(i);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}

// use stack to store number, when meet operand pop the first two numbers and operate them.
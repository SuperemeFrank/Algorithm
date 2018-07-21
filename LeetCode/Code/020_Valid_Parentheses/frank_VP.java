class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ']' || ch == ')' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (ch == ']' && stack.pop() != '[') {
                        return false;
                    }
                    if (ch == '}' && stack.pop() != '{') {
                        return false;
                    }
                    if (ch == ')' && stack.pop() != '(') {
                        return false;
                    }
                }
            } else {
                stack.push(ch);
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}

/*
    Time: O(n) Space:O(n)
    use stack 
*/
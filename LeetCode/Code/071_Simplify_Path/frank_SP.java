class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() <= 1) {
            return path;
        } 
        String res = new String();
        Stack<String> stack = new Stack<>();  
        path = path + '/';                     //to make sure the last char is '/'
        int start = 0, end = 1; 
        while (end < path.length()) {           //split path to "/**" and store in stack
            if (path.charAt(end) == '/') {
                String str = path.substring(start, end);
                if (str.equals("/..") && !stack.isEmpty()) {
                    stack.pop();
                }else if (! str.equals("/") && !str.equals("/.") && ! str.equals("/..")) {
                    stack.push(str);
                }
                start = end;
            }
            end ++;
        }
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        if (res.equals("")) {       // as this solution imply, the return should be "/" at least
            res = "/";
        }
        return res;
    }
}

/** This is a string problem: because there might be some backtrack, we use stack
    Due to "/b/../.." this condition, we need to make the judgement while store them into stack
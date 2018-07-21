public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        Stack<String> stack = new Stack<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            end = i;
            while (end + 1 < s.length() && s.charAt(end + 1) != ' ') {
                end ++;
            }
            stack.push(s.substring(i, end + 1));
            i = end + 1;
        }
        
        String res = "";
        while(! stack.isEmpty()) {
            res += stack.pop();
            res += " ";
        }
        
        if (res.length() > 1) {
            return res.substring(0, res.length() - 1);
        } else {
            return res;
        }
    }
}

// use stack to reverse the order
// use two pointers to filter single words
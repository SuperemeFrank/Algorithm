class Solution {
    public int calculate(String s) {
        
        StringBuilder newStr = new StringBuilder();
        newStr.append('+');
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != ' ')
                newStr.append(s.charAt(i));
        Deque<Character> stack = new LinkedList<>();
        boolean reverse = false;
        int i = 0, j = 0; // i is the start of current number
        int res = 0;
        boolean minors = false;
        while (j < newStr.length()) {
            char cur = newStr.charAt(j);
            if (cur == '(') {
                reverse = newStr.charAt(j - 1) == '+' ? reverse : !reverse;
                stack.offerFirst(newStr.charAt(j - 1));
                j++;
                continue;
            }
            
            if (cur == ')') {
                reverse = stack.pollFirst() == '+' ? reverse : !reverse;
                minors = reverse;
                j++;
                continue;
            }
            
            if (cur == '+') {
                minors = reverse;
                j++;
                continue;
            }
            
            if (cur == '-') {
                minors = !reverse;
                System.out.println("asd");
                j++;
                continue;
            }
            
            i = j;
            while (j < newStr.length() && newStr.charAt(j) >= '0' && newStr.charAt(j) <= '9')
                j++;
            
            String num = newStr.substring(i, j);
            if (minors) {
                System.out.println(res + "-" + Integer.valueOf(num));
            }else {
                System.out.println(res + "+" + Integer.valueOf(num));
            }
            res = minors ? res - Integer.valueOf(num) : res + Integer.valueOf(num);
            
        }
        return res;
    }
}

/*  Time: O(n)   Space: O(n)
    remove all the parentheses, set a flag to represents wether to reverse the operation
    if .. - (...) we know that all the operation in the parentheses should be reversed
    if .. + (...) do not reverse the operand
    
    use a stack to keep track of the most recent parenthese
    
    (1-(4+5+2)-3)+(6+8) ===> 1 - 4 - 5 - 2 - 3 + 6 + 8


*/
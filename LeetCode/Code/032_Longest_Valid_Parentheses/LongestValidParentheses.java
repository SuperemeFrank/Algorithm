class Solution {
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        int res = 0;
        res = Math.max(res, getMaxFronOneDirect(s));
        String reverseStr = reverse(s);
        System.out.println(reverseStr);
        res = Math.max(res, getMaxFronOneDirect(reverseStr));
        return res;
    }
    
    private int getMaxFronOneDirect(String s) {
        int lp = 0;
        int curLen = 0;
        int ukLen = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                lp++;
                ukLen++;
            }else {
                if (lp == 1) {
                    ukLen++;
                    curLen += ukLen;
                    ukLen = 0;
                    lp--;
                }else if (lp == 0) {
                    max = Math.max(max, curLen);
                    curLen = 0;
                    ukLen = 0;
                }else {
                    ukLen++;
                    lp--;
                }
            }
        }
        max = Math.max(max, curLen);
        return max;
    }
    
    private String reverse(String s) {
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            char tmp = array[i] == ')' ? '(' : ')';
            array[i] = array[j] == ')' ? '(' : ')';
            array[j] = tmp;
            i++;
            j--;
        }
        if (i == j) {
            array[i] = array[i] == ')' ? '(' : ')';
        }
        return String.valueOf(array);
    }
}


/*  Time: O(n)  Space: O(n) can be optimized to O(1)
    
    the only time we can say we got the length of current sub valid String is when ')' is more than '('
    for example, if the previous is "()()(", no matter what the next is, we don't know if this is the end of current valid string
    
    so we keep lp to record the number of '(' for current subString
    curLen to record the length of current string, which we are sure it's valid and consecutive
    ukLen to record the length of unknown part
    
    so, when lp == 0, we know that the Substring from end of known sequence to current can form a valid string, 
    then we add ukLen to curLen
    
    when lp < 0, we meet a redundant ')', which will exactly separate the previous string and the next string, so we re-record a 
    new substring
    
    [important:]  if lp always larger than 1, the curLen is always 0; like "((())"
                  so the solution is one-way directed, we need to reverse the String and do it again
*/
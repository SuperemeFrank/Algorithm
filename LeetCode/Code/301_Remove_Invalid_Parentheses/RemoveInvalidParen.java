class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, res, new StringBuilder(), 0, 0, false);
        int maxLength = 0;
        for (String str : res) {
            maxLength = Math.max(maxLength, str.length());
        }
        List<String> result = new ArrayList<>();
        for (String str : res) {
            if (str.length() == maxLength) {
                result.add(str);
            }
        }
        return result;
        
    }
    
    /* index: the current character   l: number of left paratheses
       isRemoved: whether the previous parathese is removed
    */
    private void helper(String s, List<String> res, StringBuilder prefix,
                        int index, int l, boolean isRemoved) {
        if (index == s.length()) {
            if (l == 0) {
                res.add(prefix.toString());
            }
            return;
        }
        char cur = s.charAt(index);
        if (cur != '(' && cur != ')') {
            prefix.append(cur);
            helper(s, res, prefix, index + 1, l, false);
            prefix.deleteCharAt(prefix.length() - 1);
            return;
        }
        if (cur == '(') {
            if (index > 0 && cur == s.charAt(index - 1) && isRemoved) {
                helper(s, res, prefix, index + 1, l, true);
            }else {
                prefix.append(cur);
                helper(s, res, prefix, index + 1, l + 1, false);
                prefix.deleteCharAt(prefix.length() - 1);
                helper(s, res, prefix, index + 1, l, true);
            }
        }
        
        if (cur == ')') {
            if (l == 0) {
                helper(s, res, prefix, index + 1, l, true);
            }else if (index > 0 && cur == s.charAt(index - 1) && isRemoved) {
                helper(s, res, prefix, index + 1, l, true);
            }else {
                prefix.append(cur);
                helper(s, res, prefix, index + 1, l - 1, false);
                prefix.deleteCharAt(prefix.length() - 1);
                helper(s, res, prefix, index + 1, l, true);
            }
        }
        
        
    }
}

/*  Time: O(2^n)  Space: O(n)
    record the number of left parenthese (l) and right parenthese (r)
    1. there are n levels, each level has two branch
    2. in each level, we decide whether to remove current parenthese
        case1: if not parathese, move forward
        case2: 
            2.1: if '(' , we can delete it or not
            2.2: if ')' , if r == l, we must delete it
                          else delete it or not
                 to deduplicate, if current is equal to previous one, if previous one is removed, we remove it also
                 
    

*/
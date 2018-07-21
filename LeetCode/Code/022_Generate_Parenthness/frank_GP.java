class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        helper(res, "", n, n);
        return res;
        
    }
    
    public void helper(List<String> res, String resStr, int left, int right) {
        if (left > right) {                         //invalid checking
            return;
        }
        if (left == 0 && right == 0) {              
            res.add(resStr);
            return;
        }
        if (left > 0) {                 
            helper(res, resStr + '(', left - 1, right);
        }
        
        if (right > 0) {
            helper(res, resStr + ')', left, right - 1);
        }
    }
}


/** 1. Combination problem => DFS
    2. For parathness problem, when numbers of left parathness is smaller than numbers of right ones, it must be invalid
    3. when recursion, we know that the constructure of previous string is "not wrong", and we know the numbers of left and right 
    so that if the resStr is "not wrong " till the end, the string should be one of the result.
    4. For this problem, we don't need to consider duplicate.  

**/
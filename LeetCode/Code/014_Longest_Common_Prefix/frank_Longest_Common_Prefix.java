class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minL = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            minL = minL > strs[i].length() ? strs[i].length() : minL;
        }
        
        for (int i = 0; i < minL; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minL);
    }
}


/*
    Time: O(n ^ 2)   Space: O(1)
*/
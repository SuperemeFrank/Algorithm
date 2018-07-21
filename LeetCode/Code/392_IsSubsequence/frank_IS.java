class Solution {
    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        for (int i = 0, j = 0; i < t.length(); i++) {
            if(t.charAt(i) == s.charAt(j)) {
                if (j == s.length() - 1) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }
}

//O(n)
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0 || needle == null) {
            return -1;
        }
        
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (compareStr(haystack, needle, i)) {
                    return i;
                }
            }
        }
        return -1;
    }
    public boolean compareStr(String haystack, String needle, int index) {
        int i = 0;
        while (i < needle.length() && index < haystack.length()) {
            if (haystack.charAt(index) != needle.charAt(i)) {
                break;
            }
            index++;
            i++;
        }
        if (i == needle.length()) {
            return true;
        }
        return false;
    }
}

/*
    Time: O(n*K) K is the times the first char of needle appears in haystack
    Space: O(1)
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 1;
        for (int i = 0; i < s.length() - 1; i ++) {
            String str = s.substring(i, i + 1);
            for (int j = i + 1; j < s.length(); j ++) {
                char ch = s.charAt(j);
                if (str.contains(ch + "")) {
                    res = res > (j - i) ? res : (j - i);
                    break;
                }
                if (j == s.length() - 1) {
                    res = res > (j - i + 1) ? res : (j - i + 1);
                }
                str = s.substring(i, j + 1);
            }
        }
        return res;
    }
}

/*
	Time: O(n^2) Space(n ^ 2)
	Coner Case:
		"asd" "" "abab"
*/


class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 1;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            char ch = s.charAt(j);
            if (! set.contains(ch)) {
                set.add(ch);
                res = res > (j - i + 1) ? reås : (j - i + 1);
                j ++;
            } else {
                set.remove(s.charAt(i));
                i ++;
            }
        }
        return res;
    }
}
/* 
	Time: O(n) Space: O(n)

	seems like a range, we try to extend the range to get the longest length
*/
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i < n - 1) {
                dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            }
        }
        for (int i = 1; i < n - 1; i++) {
            findPalindrome(s, dp, i - 1, i + 1);
            if (i < n - 2) {
                findPalindrome(s, dp, i - 1, i + 2);
            }
        }
        int start = 0; 
        int end = 0;
        int max = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (dp[i][j] && (j - i) > max) {
                    max = j - i;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
    
    public void findPalindrome(String s, boolean[][] dp, int left, int right) {
        int n = s.length();
        while(left >= 0 && right < n && left < right) {
                dp[left][right] = (s.charAt(left) == s.charAt(right)) && dp[left + 1][right - 1];
                left --;
                right ++;
            }
    }
}

/*
	Time: O(n^2)  Space: O(n^2)
	There are 2n -1 points, (including the points between two adjacent characters)
	expand each center to find its longest palindrome
*/


class Solution2 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        String res = "";
        for (int i = 0; i < 2 * n - 1; i++) {
            int sign = i % 2;
            int index = i / 2;
            res = getMaxSubString(s, index, sign).length() > res.length() ? getMaxSubString(s, index, sign) : res;
        }
        return res;
    }
    
    public String getMaxSubString(String s, int index, int sign) {
        int left = index;
        int right = index + sign;
        String subStr = "";
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (left < 0) {
            subStr = s.substring(0, right);
        } else {
            subStr = s.substring(left + 1, right);
        }
        
        return subStr;
    }
}

/*
	Time: O(n^2)   Space: O(1)
	Expand each center to get its longest palindrome, there are 2n - 1 centers in total
*/
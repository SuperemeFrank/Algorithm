class Solution2 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int n = s.length();
        String res = null;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (j - i <= 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                
                if (dp[i][j] && (res == null || (j - i + 1) > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
        
    }
}

/*  Time: O(n ^ 2)  Space: O(n ^ 2)
    dp[i][j] represents if the substring between i and j (inclusive) can form a palindrome
    dp[i][j] = dp[i + 1][j - 1] && s(i) == s(j)
    
    for each time, expand from center and update all 

*/

class Solution { // better in runtime
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        int max = 0;
        Integer globleLeft = null;
        Integer globleRight = null;
        for (int i = 0; i < 2 * n - 1; i++) {
            int left = i / 2;
            int right = (i + 1) / 2;
            int curLength = getMaxPalindrome(s, left, right);
            if (max < curLength) {
                max = curLength;
                globleLeft = left - (max - 1) / 2;
                globleRight = right + (max - 1) / 2;
            }
        }
        
        return s.substring(globleLeft, globleRight + 1);
    }
    
    private int getMaxPalindrome(String s, int left, int right) {
        
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}


/*  Time: O(n ^ 2)  Space: O(1)
    There will be 2n - 1 center points to be as the center of the potential palindrome
    
    the left = n / 2, right = (n + 1) / 2,    
*/
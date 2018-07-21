class Solution {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int length = s.length();
        // dp[i][j] = true, means substring(i, j + 1) is palindrome
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i ++) {  // intialize
            dp[i][i] = true;
            if (i + 1 < length) {
                dp[i + 1][i] = true;
            }
        }
        int startRow = 0;
        int startCol = 1;
        while (startCol < length) {
            int i = startRow;
            int j = startCol;
            while(j < length) {
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));    // subtring(i, j) are ditermined by substring(i + 1, j - 1)
                i ++;
                j ++;
            }
            startCol ++;
        }
        // depth[i] restore the min cut for i subString from back to start
        int[] depth = new int[length + 1];
        depth[0] = 0;
        depth[1] = 0;
        for (int i = 2; i <= length; i ++) {    // initial
            depth[i] = Integer.MAX_VALUE;
        }
        for (int i = 2; i <= length; i ++) {
            for (int j = length - i; j < length; j ++) {
                if (dp[length - i][j]) {
                        if (j == length - 1) {     // care
                            depth[i] = 0;
                        } else {
                            depth[i] = Math.min(depth[i], depth[length - j - 1] + 1);
                        }
                }
            }
        }
        return depth[length];
    }
}

// 1. first find the map of Palindrome 
// 2. use the map to find the min cut
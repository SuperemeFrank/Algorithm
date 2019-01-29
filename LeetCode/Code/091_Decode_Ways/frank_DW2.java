class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        if (s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        int n2 = 1;
        int n1 = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            int cur = 0;
            if (s.charAt(i) == '0') {
                cur = 0;
            }else if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                cur = n1 + n2;
            }else {
                cur = n1;
            }
            n2 = n1;
            n1 = cur;
        }
        
        return n1;
    }
}


/*  Time: O(n)  Space: O(1)

    2 2 2 6
    0 1 2 3

    
    dp[n] =  if n and n + 1 can be encoded：dp[n + 1] + dp[n + 2]
                                      else: dp[n + 1]
                                      
    
*/
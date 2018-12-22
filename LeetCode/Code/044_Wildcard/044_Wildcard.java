class Solution {
    public boolean isMatch(String s, String p) {
        
        // add two characters to avoid check empty s or p
        StringBuilder s1 = new StringBuilder();
        StringBuilder p1 = new StringBuilder();
        s1.append("aa");
        s1.append(s);
        p1.append("aa");
        p1.append(p);
        p = p1.toString();
        s = s1.toString();
        
        boolean M[][] = new boolean[p.length()][s.length()];
        
        M[0][0] = true;
        
        for (int i = 1; i < M.length; i++) {
            for (int j = 1; j < M[0].length; j++) {
                char pChar = p.charAt(i);
                if (pChar == '*') {
                    int k = 0;
                    while (k < M[0].length) {
                        if (M[i - 1][k]){
                            for (int start = k; start < M[0].length; start++)
                                M[i][start] = true;
                            break;
                        }
                        k++;
                    }
                    break;
                }
                
                if (M[i - 1][j - 1])
                    if (pChar == s.charAt(j) || pChar == '?')
                        M[i][j] = true;
            }
        }
        
        return M[p.length() - 1][s.length() - 1];
    }
}

/*   Time : O (n * m) n is the length of s, m is the length of p
     Space: O (n * m)

     
    2D DP
    
    M[i][j] represents whether the first i characters of p can be mathed to the first j characters of s
    M[i][j] = M[i - 1][j - 1] && check(i, j)
    
    check:
        if (char(i) == '*') for each M[i - 1][k] = true, M[i][m >= k] = true
        if (char(i) = char(j) || char(i) = '?')
    
      a d c e b
    * 1 1 1 1 1
    a 1 1 1 1 1
    * 0 1 0 0 0
    b 0 0 1 0 0
    
*/


class Solution2 {
    public boolean isMatch(String s, String p) {
        StringBuilder p1 = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            if (i != 0 && p.charAt(i) == p.charAt(i - 1) && p.charAt(i) == '*') {
                continue;
            }
            p1.append(p.charAt(i));
        }
        return isMath(s, p1.toString(), 0, 0);
    }
    
    private boolean isMath(String s, String p, int sp, int pp){
        
        while (sp < s.length() && pp < p.length()) {
            char pChar = p.charAt(pp);
            if (pChar == '*') {
                for (int i = sp; i <= s.length(); i++)
                    if (isMath(s, p, i, pp + 1))
                        return true;
                return false;
            }else if (pChar == s.charAt(sp) || pChar == '?') {
                pp++;
                sp++;
                continue;
            }else {
                return false;
            }
        }
        
        return (sp == s.length() && pp == p.length()) || 
            (pp == p.length() - 1 && p.charAt(pp) == '*');
    }
}

/*   O (n^(e+1))  e is the number of *
    two pointers, recursive
    when meet *, it would be the same subproblem
    when meet ? jump one character

*/
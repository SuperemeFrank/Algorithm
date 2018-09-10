class Solution {
    public boolean canWinNim(int n) {
        
        return n % 4 != 0;
    }
}

class Solution2 {
    public boolean canWinNim(int n) {

        boolean[] M = new boolean[3];
        if (n <= 3) {
            return true;
        }
        M[0] = true;
        M[1] = true;
        M[2] = false;
        boolean cur = false;
        for (int i = 5; i <= n; i++) {
            cur = !(M[0] && M[1] && M[2]);
            M[0] = M[1];
            M[1] = M[2];
            M[2] = cur;
        }
        
        return cur;
    }
}

/*  Time: O(n)  Space: O(1)
    assume A is ourselves, and B is our competitor
    for n whether A can win is depend on whether B can win if at first A pick 1, 2, 3
    
    because A, B are both smart enough, so if there is a way can make sure they win, they will do that.
    
    assume M[i] represents whether A can win if there are i stones
    when A pick 1 at first, the defeat of B is M[i - 1]
    similarly, A pick 2, the defeat of B is M[i - 2]
               A pick 3, the defeat of B is M[i -3]
               
    if A want to win at M[i], he must find a way (pick 1 or 2 or 3) to make B lose the game
    so M[i] = !(M[i - 1] && M[i - 2] && M[i - 3])
    
    finnaly we find there is a rule: t t t f | t t t f...
    each 4 elements can be a group
*/
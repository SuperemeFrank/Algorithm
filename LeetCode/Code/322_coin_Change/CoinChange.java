class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] M = new int[amount + 1];
        M[0] = 0;
        for (int i = 1; i < M.length; i++) {
            M[i] = -1;
        }
        for (int i = 1; i < M.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int curCoin = coins[j];
                if (i - curCoin >= 0) {
                    if (M[i - curCoin] == -1) {
                        continue;
                    }
                    M[i] = M[i] == -1 ? (M[i - curCoin] + 1) : Math.min(M[i], M[i - curCoin] + 1);
                }
            }
        }
        return M[amount];
    }
}

/* Time: O(amount * coins)   Space: O(amount)

    M[i] preresents to for the amount = i, the min number of coin can reach
    for all coins cn, M[i] = max{M[i - cn] != -1 ? M[i - cn] + 1 : -1}, 
    
*/
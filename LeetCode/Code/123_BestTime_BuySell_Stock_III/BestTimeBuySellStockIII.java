class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE, sell1 = 0, sell2 = 0;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        
        return sell2;
    } 
}


/* Time: O(n)  Space: O(1)
    improved from dp 


*/

class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int curProfit = getProfit(prices, 0, i - 1) + getProfit(prices, i, n - 1);
            max = Math.max(max, curProfit);
        }
        return max;
    }
    
    
    private int getProfit(int[] prices, int l, int r) {
        if (l < 0)
            return 0;
        int subMax = 0;
        int curMin = prices[l];
        for (int i = l; i <= r; i++) {
            if (prices[i] > curMin) {
                subMax = Math.max(subMax, prices[i] - curMin);
            }else {
                curMin = prices[i];
            }
        }
        
        return subMax;
    }
}



/* Time: O(n^2)  Space: O(1)
    To find the max profit in at most two transactions is to find the position that can seperate the prices into two parts
    then get the largest profit



*/
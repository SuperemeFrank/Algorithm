class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        
        sell[0] = 0;
        buy[0] = -prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0) - prices[i]);
        }
        
        return sell[prices.length - 1];
    }
}

/*  Time: O(n)  Space: O(n)  can be opimize to O(1)
    there are two states, 
    buy[i] represents ith day when holding stock, the max benifits
    sell[i]  represents the ith day when sells stock, the max benifits
    
    there are two cases for buy[i]:
    1. the ith day is the same with i - 1th day, not sell stock
    2. sell stock at the i - 2 th day, and buy stock today
    
    buy[i] = max{buy[i - 1], sell[i - 2] - prices[i]}
    
    there are two cases for sell[i]:
    1. didn't sell stock today, the same as the i - 1th day
    2. sell stock today
    
    sell[i] = max{sell[i - 1], buy[i - 1] + prices[i]}
*/
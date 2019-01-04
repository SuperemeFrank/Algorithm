class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        
        return profit;
    }
}


/*  Time : O(n)  Space: O(1)

    It means we can but and sell at the same day
    to make the profit maximum is to add all the profit that we can make among each day

    So we just need to find all the consecutive positive difference

*/
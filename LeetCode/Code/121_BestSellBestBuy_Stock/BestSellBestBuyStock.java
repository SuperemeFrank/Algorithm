class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int preMin = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > preMin) {
                max = Math.max(max, prices[i] - preMin);
            }else {
                preMin = prices[i];
            }
        }
        
        return max;
    }
}

/* Time: O(n)  Space: O(1)
    The problem can be translate to find the max difference in the array which the small one is at previous of the bigger one

*/
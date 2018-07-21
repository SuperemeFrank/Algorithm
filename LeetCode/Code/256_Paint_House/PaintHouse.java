
class Solution {
    int min = Integer.MAX_VALUE;
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int len = costs.length;
        for (int i = 1; i < costs.length; i++) {
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(Math.min(costs[len - 1][0], costs[len - 1][1]), costs[len - 1][2]);
    }
}
// Time: O(n)   Space: O(1)


/*
    for each level of costs[i][j], the min costs depends on the minCost of costs[i - 1][!j]
    so we should concern all posibilities


    when we use dfs below, we care each path of the way painting.
*/




class DFSSolution {
    int min = Integer.MAX_VALUE;
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }     
        dfsHelper(costs[0][0], 0, 1, costs);
        dfsHelper(costs[0][1], 1, 1, costs);
        dfsHelper(costs[0][2], 2, 1, costs);
        return min;
    }
    private void dfsHelper(int curSum, int preColor, int curHouse, int[][] costs) {
        if (curHouse > costs.length - 1) {
            min = min < curSum ? min : curSum;
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (i != preColor) {
                dfsHelper(curSum + costs[curHouse][i], i, curHouse + 1, costs);
            }
        } 
    }
}
// Time: O(2 ^ n)   Space: O(height)


/*
level represents the house
                                no paint
                               /   |   \
1st house                    r     b     g
                          /  |    / \
2rd                      b   g   r   g    ..
                       / |  / \
                       ...........
*/
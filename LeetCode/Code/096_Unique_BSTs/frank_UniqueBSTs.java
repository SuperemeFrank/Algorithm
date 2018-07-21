class Solution {
    public int numTrees(int n) {
        //dp[n] means the numbers of BST by n nodes
        int[] dp = new int[n + 1];
        //initialize dp[0] if 0 nodes, dp[1] if 1 nodes
        dp[0] = 1;
        dp[1] = 1;
        
        //level means the number of nodes to build BST
        for (int level = 2; level <= n; level ++) {
            for (int root = 1; root <= level; root ++) { //root means the position of the root 
                dp[level] += dp[root - 1] * dp[level - root];
            }
        }
        return dp[n];
    }
}

//ID = 1
//Tail Connection
//Dedution 
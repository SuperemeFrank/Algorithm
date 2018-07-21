/*  greedy
    if start from i cannot reach j, then the next start should be j + 1
*/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0 || cost.length == 0) {
            return -1;
        }
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < gas.length; i ++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if (costSum > gasSum) {
            return -1;
        }      
        int[] minors = new int[gas.length];
        for (int i = 0; i < gas.length; i ++) {
            minors[i] = gas[i] - cost[i];
        }
        int i = 0;
        while (i < gas.length) {
            int iter = i;
            int sum = minors[i];
            while (sum >= 0) {
                iter = (iter + 1) % gas.length;
                sum += minors[iter];
                if (iter == i) {
                    return i;
                }
            }
                i = iter + 1;
        }
        return -1;
        
    }
}


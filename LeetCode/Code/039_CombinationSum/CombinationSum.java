class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);  // ascending order
        dfsHelper(res, candidates, candidates.length - 1, new ArrayList<>(), target);
        return res;
    }

    private void dfsHelper(List<List<Integer>> res, int[] candidates, 
                                        int level, List<Integer> list, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (level < 0 || target < 0) {
            return;
        }

        int current = candidates[level];
        int times = target / current;
        for (int i = 0; i <= times; i++) {
            for (int j = 0; j < i; j++) {
                list.add(current);
            }
            dfsHelper(res, candidates, level - 1, list, target - (current * i));
            for (int j = 0; j < i; j++) {
                list.remove(list.size() - 1);
            }
        }
    }
}


/*
                     5, 3,  2                                14
                    /      |      \
5                0    1       2 
                / || \
3            0 1 2 3


dfs:  each level should be the number of a specific elemenets

        mean   target / mean branches

        Time: O(n ^ (target / mean))
        Space: O(height)                
*/


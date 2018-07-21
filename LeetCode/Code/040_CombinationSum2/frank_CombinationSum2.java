class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // corner case 
        if (candidates == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfsHelper(res, candidates, target, 0, new ArrayList<>());
        return res;
    }
    
    public void dfsHelper(List<List<Integer>> res, int[] candidates, 
                          int target, int index, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (index >= candidates.length) {
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i - 1]) { // deDuplicate
                continue;
            }
            list.add(candidates[i]);
            dfsHelper(res, candidates, target - candidates[i], i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
// Time: O(n + (n-1)! + (n - 2)! +... + 1 ~ O(n^3)   ?
//  Space: O(n + n) ~ O(n)
/* 1. Combination problem => DFS
    2. We need visited[] to delete duplicates
    3. Traverse from left to right, add all possible combinations to resList

#To delete duplicates, we also can write if (i != startIndex && nums[i] == nums[i - 1]) continues;
*/
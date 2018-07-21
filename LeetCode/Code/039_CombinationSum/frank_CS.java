// 每一层的意义是加哪种candidate
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        int[] nums = removeDuplicate(candidates);
        helperDFS(nums, 0, res, new ArrayList<Integer>(), target);
        return res;
    }
    
    private void helperDFS(int[] nums, int startIndex, List<List<Integer>> res, List<Integer> resList, int target) {
        
        if (target == 0) {
            res.add(new ArrayList<Integer>(resList));
            return;
        }
        
        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            resList.add(nums[i]);
            helperDFS(nums, i, res, resList, target - nums[i]);
            resList.remove(resList.size() - 1);
        }
        
    }
    
    private int[] removeDuplicate(int[] candidates) {
        Arrays.sort(candidates);
        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
             if(candidates[index] != candidates[i]) {
                 candidates[++index] = candidates[i];
             }
        }
        int[] nums = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            nums[i] = candidates[i];
        }
        
        return nums;
    }
}

// Time O(n^k) k is the level of the tree(target / smallest candidate), n is the number of candidates
// Space: O(k)

// 每层意义是这个candidate加多少个
class Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // corner case
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfsHelper(res, candidates, target, 1, new ArrayList<>());
        return res;
    }
    
    public void dfsHelper(List<List<Integer>> res, int[] candidates, int target,
                         int level, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (level == candidates.length) {
            if (target % candidates[0] == 0) {
                for (int j = 0; j < (target / candidates[0]); j++) {
                    list.add(candidates[0]);
                }
                res.add(new ArrayList(list));
                for (int j = 0; j < (target / candidates[0]); j++) {
                    list.remove(list.size() - 1);
                }
            }
            return;
        }
        
        int n = candidates.length;
        int candidate = candidates[n - level];
        int maxNum = target / candidate;
        
        for (int i = 0; i <= maxNum; i++) {
            for (int j = 0; j < i; j++) {
                list.add(candidate);
            }
            dfsHelper(res, candidates, target - i * candidate, level + 1, list);
            for (int j = 0; j < i; j++) {
                list.remove(list.size() - 1);
            }
        }
    }
}

// Time: O(k^n)    k: target / smallest candidate      n: number of candidates
//Space: O(n)    
// Normally n is far smaller than k, so Solution2 is better


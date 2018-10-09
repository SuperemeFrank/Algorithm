class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfsHelper(res, nums, new ArrayList<>(), 0);
        return res;
    }
    
    private void dfsHelper(List<List<Integer>> res, int[] nums, List<Integer> prefix, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(prefix));
            return;
        }
        int j = index + 1;
            
        while (j < nums.length && nums[j] == nums[index]) {
            j++;
        }
        dfsHelper(res, nums, prefix, j);
        prefix.add(nums[index]);
        dfsHelper(res, nums, prefix, index + 1);
        prefix.remove(prefix.size() - 1);
    }
}


/* Time: O(n^2)   Space:O(n)
    for each one, pick or not pick
    
                    1, 2, 2, 3
                    /      \
1                  1        null
                  / \         /\
2                2   null    2  null
               /  \     |
2             2   null  null
...
*/


// BackTracking Problem
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       if (nums == null || nums.length == 0) {
           return null;
       } 
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        dfsHelper(nums, res, subset, 0, visit);
        return res;
    }
    
    public void dfsHelper(int[] nums, List<List<Integer>> res, List<Integer> subset, int startIndex, boolean[] visit) {
        res.add(new ArrayList<>(subset));

        
        for(int i = startIndex; i < nums.length; i++) {
            if (visit[i]) continue;
            if(i > startIndex && nums[i] == nums[i - 1]) continue;
                
            visit[i] = true;
            subset.add(nums[i]);
            dfsHelper(nums, res, subset, i + 1, visit);
            subset.remove(subset.size() - 1);
            visit[i] = false;
        }
    }
}




//

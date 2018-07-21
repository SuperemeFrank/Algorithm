// BackTracking Problem
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       if (nums == null || nums.length == 0) {
           return null;
       } 
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfsHelper(nums, res, subset, 0);
        return res;
    }
    
    public void dfsHelper(int[] nums, List<List<Integer>> res, List<Integer> subset, int startIndex) {
        res.add(new ArrayList<Integer>(subset));
        for(int i = startIndex; i < nums.length; i++) {
            /* i == startIndex && nums[i] == nums[i - 1] means: 
                this duplicate element will increase the length of subset, thus it is valid; 
                While i != startIndex && nums[i] == nums[i - 1] means: 
                the number equals to nums[i] has been added and then removed from the subset,
            */
            if(i > 0 && nums[i] == nums[i - 1]) { 
                continue;
            }
            subset.add(nums[i]);
            dfsHelper(nums, res, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}

//BackTracking Problem
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int startIndex = 0;
        dfsHelper(nums, startIndex, subset, res);
        return res;
    }
    
    //Put all the possible set begin with subset to res
    public void dfsHelper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            dfsHelper(nums, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
        // there is no gate of this recursion because when i = nums.length this recursion will automatically end
    }
}

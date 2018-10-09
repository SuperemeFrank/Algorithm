class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfsHelper(res, nums, 0);
        return res;
    }
    
    private void dfsHelper(List<List<Integer>> res, int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            res.add(toList(nums));
            return;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (set.add(nums[i])) {
                swap(nums, startIndex, i);
                dfsHelper(res, nums, startIndex + 1);
                swap(nums, startIndex, i);
            }
        }
    }
    
    private List<Integer> toList(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
        }
        return res;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}


/*  Time: O(n!)  Space: O(n)

    to deduplicate, because we use swap, we cannot use i != start && nums[i] == nums[i - 1] to do that.
                    1 1 2
                    /     \
0                  1   (1) 2
                /   \     / 
1              1    2    1  
               /    /    /      
2            2     1     1
*/
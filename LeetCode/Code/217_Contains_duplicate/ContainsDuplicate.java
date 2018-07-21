class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}

// Time: O(n)   Space: O(n)
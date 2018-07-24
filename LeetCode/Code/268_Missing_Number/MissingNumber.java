class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            if (i < nums.length) {
                res ^= (i ^ nums[i]);
            }else {
                res ^= i;
            }
        }
        return res;
    }
}

// Time: O(n). Space: O(1)
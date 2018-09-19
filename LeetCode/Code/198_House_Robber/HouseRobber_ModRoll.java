class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] M = new int[2];
        M[0] = nums[0];
        M[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            M[i % 2] = Math.max(M[(i - 2) % 2] + nums[i], M[(i - 1) % 2]);
        }
        
        return M[(nums.length - 1) % 2];
    }
}
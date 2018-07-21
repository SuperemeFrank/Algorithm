class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int res = 0;
        for (int i : nums) {
            res = res ^ i;
        }
        return res;
    }
}
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int rotate = k % nums.length;
        if (rotate == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, rotate - 1);
        reverse(nums, rotate, nums.length - 1);
        return;
    }
    
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start ++;
            end --;
        }
    }
}
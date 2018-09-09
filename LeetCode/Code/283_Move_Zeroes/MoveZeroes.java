class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }
        
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}

// Time: O(n)  Space: O(1)


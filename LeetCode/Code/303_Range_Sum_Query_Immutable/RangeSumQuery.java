class NumArray {
    int[] preSum;
    public NumArray(int[] nums) {
        preSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                preSum[i] = nums[i];
            }else {
                preSum[i] = nums[i] + preSum[i - 1];
            }
            
        }
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) {
            return preSum[j];
        }else {
            return preSum[j] - preSum[i - 1];
        }
    }
}

/** amortized time: O(1)
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
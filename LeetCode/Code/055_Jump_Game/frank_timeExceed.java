class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        boolean res;
        int nextPos = nums[0];
        res = helper(nums, 0, nextPos);
        return res;
    }
    
    public boolean helper(int[] nums, int start, int nextPos) {
        boolean res = false;
        if (nextPos >= nums.length - 1){
            return true;
        }
        for (int i = start + 1; i <= nextPos; i++) {
            res = res || helper(nums, i, i + nums[i]);
            if(res == true) {
                return true;
            }
        }
        return res;
    }
}

//DFS, if the length is large, this solution will time exceeded
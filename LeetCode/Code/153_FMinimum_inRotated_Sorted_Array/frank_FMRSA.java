class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = nums.length - 1;
        int wall = nums[nums.length - 1];
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] <= wall) { // if nums[mid] <= wall , the min must at the left side
                right = mid;
            } else { // if nums[mid] > wall , the min must at the right side
                left = mid;
            }
        }
        
        return Math.min(nums[left], nums[right]);
    }
}

/* Binary search
    Assume the target is the minimum
*/
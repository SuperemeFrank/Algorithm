class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (mid > 0 && mid < nums.length - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                    left = mid;
                } else if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    right = mid;
                } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    left ++;
                }
            }
            
            if (mid == 0) { // if mid = 0, the nums[mid + 1] must smaller than nums[mid]
                return mid;
            }
            
            if (mid == nums.length - 1) { // same as mid = 0
                return mid;
            }
        }
        if (nums[left] > nums[right]) {
            return left;
        } else {
            return right;
        }
    }
}

/* 
    1. the peak must be either in the nums, or at the edge of nums.
    2. for the mid that in the nums, if it's ascending and the nums[right] is descending, the peak occurs in mid - right 
    3. The same as if the mid is descending

*/
class Solution {
    public int searchInsert(int[] nums, int target) {
        // coner case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] == target) {    // the one is not considered
            return left;
        } else if (nums[left] < target) {
            return left + 1;
        } else {
            return left;
        }
    }
}

/*Time: O(logn) Space: O(1)

*/
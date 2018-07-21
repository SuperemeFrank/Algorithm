class Solution {
    public int[] searchRange(int[] nums, int target) {
        //corner case
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) { // find first position
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (nums[right] == target) {  // if target exists
            int start = right;
            int end = nums.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] <= target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (nums[end] == target) {
                return new int[]{right, end};
            }
            if (nums[start] == target) {
                return new int[]{right, start};
            }
        } 
        return new int[]{-1, -1};
    }
}

//First Position + last Position
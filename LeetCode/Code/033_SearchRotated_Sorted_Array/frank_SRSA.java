//Binary Search O(logn)
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int begin = 0, end = nums.length - 1;
        while (begin + 1 < end) {
            int mid = (end - begin)/2 + begin;
            if (target == nums[mid]) {
                end = mid;
            } else if(nums[mid] < nums[end]) {
                if (target >= nums[mid] && target <= nums[end]) {
                    begin = mid;
                }else {
                    end = mid;
                }
            }else {
                if (target <= nums[mid] && target >= nums[begin]) {
                    end = mid;
                }else {
                    begin = mid;
                }
            }
        }
        //double check
        if (nums[begin] == target) {
            return begin;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
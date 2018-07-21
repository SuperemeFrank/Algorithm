class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        int dividePos = nums[0];        
        while (left + 1 < right) {
            int mid = (right - left)/2 + left;
            if (nums[mid] < nums[left] || nums[mid] < nums[right]) {  //nums[mid] at the right part
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid;
                }else {
                    right = mid;
                }
            }else if (nums[mid] > nums[left] || nums[mid] > nums[right]) { //nums[mid] at the left part
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid;
                }else {
                    left = mid;
                }
            } else {            //if the start == end
                left ++;    // because left == right, even if left is the target, the target is also in out scope due to right
            }
        }
        if (nums[left] == target || nums[right] == target) {
            return true;
        }
        return false;
    }
}

//The key of binary search is that at certain condition, we just need to know when the target 
//might locate in one side, and otherwise it will locate at another side of mid.


class Solution2 {
    public boolean search(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) {
            return false;
        }
        int lBound = nums[0];
        int rBound = nums[nums.length - 1];
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] > lBound || nums[mid] > rBound) { // on first array
                if (target >= lBound && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < rBound || nums[mid] < lBound) { // on second array
                if (target <= rBound && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {    // don't know
                if (nums[left] != target) {
                    left += 1;
                }else {
                    return true;
                }
            }
        }
        return false;
    }
}
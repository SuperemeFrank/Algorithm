class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int pivot = nums[0];
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            if (nums[mid] == target) {
                return mid;
            }else if (target < pivot) {
                if (nums[mid] < target || nums[mid] >= pivot) {
                    left = mid + 1;
                    System.out.println(left);
                }else {
                    right = mid - 1;
                }
            }else {
                if (nums[mid] > target || nums[mid] < pivot) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}

/* Time: O(logn)  Space: O(1)

    xxxxx00000
    
    pivor is the first number, all the numbers in part1 are larger than pivot and all in part2 are smaller
    
    if mid < pivot && mid > target, right = mid - 1
    

*/
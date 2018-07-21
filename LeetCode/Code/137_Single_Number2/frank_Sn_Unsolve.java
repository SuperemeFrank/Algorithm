
/*
    sort first, AND and OR each 3 number
    if the single number is not the last one:
        it must be first one of a pair, then sin & nums[i + 1] != nums[i + 1];
    else its the last one
*/
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        Arrays.sort(nums);
        int i = 0;
        int res = nums[0];
        while (i < nums.length) {
            if (i == nums.length - 1) {
                return nums[i];
            }
            res = nums[i];
            res &= nums[i + 1];
            if (res != nums[i + 1]) {
                return nums[i];
            }
            res ^= nums[i + 2];
            i = i + 3;
        }
        return -1;
    }
}

// The Arrays.sort() is O(nlogn), does not satisfy the O(n) requirement
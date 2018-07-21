class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int digit = 0;
        while ( ((xor >> digit) & 1) == 0) {
            digit++;
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (((nums[i] >> digit) & 1) == 0) {
                res[0] ^= nums[i];
            }
            if (((nums[i] >> digit) & 1) == 1) {
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
    // Time: O(n)  Space: O(1)
/*
    first: we xor all the numbers to get the xor of 2 distinct numbers
    second: assume the ith digit of xor is 1, it means the two distinct numbers are different at ith digit
            so we can separate the array into two groups based on their ith digit, then we xor all the numbers
            that their ith digits are 1 to get the first distinct number, and ith digits are 0 to get the second
*/



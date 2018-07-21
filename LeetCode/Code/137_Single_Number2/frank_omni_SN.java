class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < 32; i ++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j ++) {
                if (((nums[j] >> i) & 1) == 1) {
                    sum ++;
                    sum = sum % 3;
                }
            }
            res |= sum << i;
        }
        return res;
        
    }
}

/*
    This is an omnipotent solution for single number, the mod could be 2, 3, 4, 5, ...

    the int in java is 32 bit, 
    1. count the number 1 of each bit 
    2. the sum of each bit mod 3,  if the single number at this bit is 1, sum % 3 must be 1
    3. reconstruct the single number


    The complexity is O(32n) ~ O(n)
*/
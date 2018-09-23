class Solution {
    public boolean isPowerOfFour(int num) {
        boolean flag = false;
        for (int i = 0; i < 32; i++) {
            if ((num >> i & 1) == 1) {
                if (flag || i % 2 == 1) {
                    return false;
                }
                flag = true;
            }
        }
        return flag;
    }
}

/*  Time: O(1)  Space: O(1)
    if a number is power of 4, its bits would be like 1000000000, there would be a 1 at odd digits, the rest are all 0
*/
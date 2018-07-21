class Solution {
    public int mySqrt(int x) {
        if (x < 1) {
            return 0;
        }
        long left = 1;
        long right = x;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (right * right <= x) {
            return (int)right;
        }
        if (left * left <= x) {
            return (int)left;
        }
        return -1;
    }
}


/* Time: O(x)   Space: O(1)
    take care of over boundary
*/

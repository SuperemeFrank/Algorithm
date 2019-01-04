class Solution {
    public int mySqrt(int x) {
        long right = 2;
        while (right * right < x) {
            right *= 2;
        }
        
        long left = 0;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                left = mid; 
            }else {
                right = mid;
            }
        }
        if (right * right <= x) return (int)right;
        return (int)left;
    }
}

/* Time: O(logn)   Space:O(1)
    get the boundary of decimal
    
    binary search the last one, the square of which is smaller than x

*/

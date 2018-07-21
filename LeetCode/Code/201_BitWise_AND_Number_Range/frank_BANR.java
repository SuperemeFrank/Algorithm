class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        double res = 0;
        int pow = 0;
        while (Math.pow(2, pow) <= m) {
            pow ++;
        }
        double highDigit = Math.pow(2, pow - 1);
        while (highDigit > 0) {
            if (highDigit * 2 > n && highDigit <= m) {
                res += highDigit;
                n -= highDigit;
                m -= highDigit;                
            }
            highDigit /= 2;
        }
        return (int)res;
    }
}

// Judge from the highest digit 
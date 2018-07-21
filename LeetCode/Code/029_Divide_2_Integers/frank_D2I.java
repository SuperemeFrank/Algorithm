class Solution {
    public int divide(int dividend, int divisor) {
        int res = Integer.MAX_VALUE;
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        long ldividend = Math.abs((long)dividend);  // if ldividend is int type, it will be 0 if dividend is -2147483648
        long ldivisor = Math.abs((long)divisor);
        if (ldividend < ldivisor || ldivisor == 0) {
            return 0;
        }
        long lres = ldivide(ldividend, ldivisor);
        res = lres * sign < Integer.MAX_VALUE ? (int)lres * sign : res;
        return res;
    }
    
    public long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) {
            return 0;
        }
        long sum = ldivisor;
        long multiple = 1;
        while((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}

/*
1. + -
2. Overflow
3. = 0
4. Normal condition
Due to the time limitation, here use ^2 recursion
*/
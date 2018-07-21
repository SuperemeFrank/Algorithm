class Solution {
    public int reverse(int x) {
        long res = 0;
        int sign = 1;
        if (x < 0) {
            sign = -1;
        }
        long num = Math.abs(x);
        while (num != 0) {
            long digit = num % 10;
            num /= 10;
            res = res * 10 + digit;
        }
        res = res * sign;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)res;
    }
}

/*
	Time: O(n) n = digits of x  Space: O(1)
	
*/
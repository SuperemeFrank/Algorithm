class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        long sign = 1;
        long num = 0;
        int x = 0;
        int n = str.length();
        while (x < n && str.charAt(x) == ' ') {
            x++;
        }
        String leftStr = "";
        if (x < n) {
            if (x < n - 1 && str.charAt(x) == '-') {
                sign = -1;
                leftStr = str.substring(x + 1, n);
            } else if (x < n - 1 && str.charAt(x) == '+'){
                leftStr = str.substring(x + 1, n);
            } else{
                leftStr = str.substring(x, n);
            }
        }
        for (int i = 0; i < leftStr.length(); i++) {
            char ch = leftStr.charAt(i);
            if (ch < '0' || ch > '9') {
                break;
            } else {
                num = num * 10 + (ch - '0');
            }
            if (num * sign > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
            }
            if (num * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        num = num * sign;
        
        return (int)num;
    }
}

/*
	Time: O(n) Space: O(1)
	Coner Case:
	" "  
	" -" 
	" +"  
	"  +121"
	"9223372036854775808"   //out of long range
	"2147483648"
	"-2147483649"  
*/
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = x + "";
        int length = str.length();
        int left = 0;
        int right = 0;
        if (length % 2 > 0) {
            left = length / 2;
            right = left;
        } else {
            left = length / 2 - 1;
            right = left + 1;
        }
        while (left >= 0 && right < length) {
            if (str.charAt(left--) != str.charAt(right++)) {
                return false;
            }   
        }
        return true;
    }
}

/*
	Time: O(n) Space: O(1)
	Coner Case:
	
*/
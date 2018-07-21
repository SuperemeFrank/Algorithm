class Solution {
    public String intToRoman(int num) {
        StringBuilder strb = new StringBuilder();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < nums.length; i ++) {
            int digits = 0;
            digits = num / nums[i];
            num -= digits * nums[i];
            for (int j = 0; j < digits; j++) {
                strb.append(roman[i]);
            }
        }
        return strb.toString();
    }
}

/*
    Time: O(n) n is the digits of num     Space: O(n)

    Use to Arrays to map all the roman characters
*/
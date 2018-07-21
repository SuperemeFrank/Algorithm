class Solution {
    public int addDigits(int num) {
        
        while (num > 9) {
            int newNum = 0;
            while (num != 0) {
                int digit = num % 10;
                num = num / 10;
                newNum += digit;
            }
            num = newNum;
        }
        return num;
    }
}

// Time: O(2n) assume all digits are 9    Space: O(1)
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            double newNum = 0;
            int digit = 0;
            while (n != 0) {
                digit = n % 10;
                newNum += Math.pow(digit, 2);
                n /= 10;
            }
            n = (int)newNum;
            newNum = 0;
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
}
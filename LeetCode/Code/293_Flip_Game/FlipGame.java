class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        char[] str = s.toCharArray();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (str[i] == '+' && str[i + 1] == '+') {
                str[i] = '-';
                str[i + 1] = '-';
                res.add(String.valueOf(str));
                str[i] = '+';
                str[i + 1] = '+';
            }
        }
        return res;
    }
}

// Time: O(n)  Space: O(n)
class Solution {
    public boolean canPermutePalindrome(String s) {
        
        int[] bitMap = new int[8];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int row = ch / 32;
            int col = ch % 32;
            bitMap[row] ^= (1 << col);
        }
        int count = 0;
        for (int map : bitMap) {
            for (int i = 0; i < 31; i++) {
                if (((map >> i) & 1) == 1) {
                    count++;
                }
            }
        }
        return count < 2;
    }
}

// Time: O(n)  Space: O(1)


class Solution2 {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }else {
                map.put(ch, 1);
            }
        }
        int countOdd = 0;
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                countOdd++;
            }
        }
        return countOdd < 2;
    }
}

// Time: O(n)  Space: O(n)
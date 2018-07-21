class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i < s.length() - 1 && map.get(s.charAt(i + 1)) > map.get(ch)) {
                int num = map.get(s.charAt(i + 1)) - map.get(ch);
                res += num;
                i++;
            } else {
                res += map.get(ch);
            }
        }
        return res;
    }
}

/*
    Time: O(n) Space: O(1)
*/
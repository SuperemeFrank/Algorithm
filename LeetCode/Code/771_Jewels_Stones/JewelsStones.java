class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null) {
            return 0;
        }
        Set<Character> jewels = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            jewels.add(J.charAt(i));
        }
        
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (jewels.contains(S.charAt(i))) {
                count++;
            }
        }
        
        return count;
    }
}

// Time: O(Max(n, m))  Space: O(n)  n is length of J, m is length of S
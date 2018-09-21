class Solution {
    public String reverseString(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder prefix = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            prefix.append(s.charAt(i));
        }
        return prefix.toString();
    }
}

// Time: O(n)  Space: O(n)
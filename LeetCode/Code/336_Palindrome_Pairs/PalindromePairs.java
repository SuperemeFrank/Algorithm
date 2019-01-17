class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {

        if (words == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                String first = words[i];
                String second = words[j];
                if (isPalindromePair(first, second)) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    res.add(pair);
                }
            }
        }
        return res;
    }

    private boolean isPalindromePair(String first, String second) {
        StringBuilder sb = new StringBuilder();
        sb.append(first);
        sb.append(second);
        int i = 0;
        int j = sb.length() - 1;
        while (i < j) {
            if (sb.charAt(i++) != sb.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
/* Time: O(n^2 * m)  m is the average length of all words.   Space: O(m)
key points: 
1.the two strings might not be the same length
2. the order of two strings is also important


*/

//

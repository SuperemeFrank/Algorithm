class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }        
        helper(res, new ArrayList<>(), s);
        return res;
    }
    // add the first n palindrome substring to list, and recurse the rest string
    public void helper(List<List<String>> res, List<String> list, String s) {
        if (s.length() == 0) {
            res.add(new ArrayList<String>(list));
        }
        for (int i = 0; i < s.length(); i ++) {
            String str = s.substring(0, i + 1);
            if (isPalind(str)) {
                list.add(str);
                helper(res, list, s.substring(i + 1, s.length()));
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean isPalind(String str) {
        for (int i = 0; i < str.length() / 2; i ++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

//DFS,
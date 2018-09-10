class Solution {
    public boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (words.length != pattern.length())
        return false;
    Map index = new HashMap();
    for (Integer i=0; i<words.length; ++i)
        // put() function return previous value associated with key
        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
            return false;
    return true;
    }

}
// Time: O(n) space: O(n)

class Solution2 {
    public boolean wordPattern(String pattern, String str) {
        
        int k = 0;
        List<String> strs = new ArrayList<>();
        for (int j = 0; j < str.length(); j++) {
            while (str.charAt(k) == ' ') {
                k++;
                j = k;
            }
            if (str.charAt(j) == ' ') {
                strs.add(str.substring(k, j));
                k = j;
            }
        }
        strs.add(str.substring(k, str.length()));
        if (strs.size() != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char cur = pattern.charAt(i);
            for (int j = i - 1; j >= 0; j--) {
                char pre = pattern.charAt(j);
                if (pre == cur && !strs.get(i).equals(strs.get(j))) {
                    System.out.println(i + " "+ j);
                    return false;
                }else if (pre != cur && strs.get(i).equals(strs.get(j))) {
                    System.out.println(2);
                    return false;
                }
            }
        }
        return true;
    }
}

/* Time: O(n ^ 2)  n is the length of str   Space: O(n)
    1. split str to array
    2. math the array with the pattern
    
*/
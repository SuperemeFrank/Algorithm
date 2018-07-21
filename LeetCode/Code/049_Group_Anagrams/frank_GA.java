class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<>(); // S: O(n)
        for (String str : strs) { // O(n)
            char[] ch = str.toCharArray();   // Space: O(k)  TimeL O(k)
            Arrays.sort(ch);                //important    Time: O(klogk)
            String s = new String(ch);
            if (map.containsKey(s)) {
                List<String> list = res.get(map.get(s));
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, res.size());
                res.add(list);
            }
        }
        return res;
    }
    
}
// Time: O(nklogk)  Space: O(n + k)


/** 1.don't need to obtain combinations of each string, just sort them see if they are the same
    2.Use HashMap to store (sorted String, index of its resList in res), if a String is contained in the map
      after sorted, restore it in its corresponding list; if not, create new one.
**/
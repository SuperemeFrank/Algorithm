

// passed
class Solution1 {
    public List<String> generatePalindromes(String s) {
        // TODO: corner case
        
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int odd = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int num = map.get(ch);
                odd = num % 2 == 0 ? odd + 1 : odd - 1;
                map.put(ch, num + 1);
            }else {
                map.put(ch, 1);
                odd++;
            }
        }
        if (odd > 1) {
            return res;
        }
        String mid = "";
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            int num = entry.getValue();
            if (num % 2 == 1) {
                entry.setValue((num - 1) / 2);
                mid = entry.getKey() + "";
            }else {
                entry.setValue(num / 2);
            }
        }
        int size = s.length() / 2;
        dfsHelper(map, res, new StringBuilder(), mid, size);
        return res;
    }
    private void dfsHelper(Map<Character, Integer> map, List<String> res,
                          StringBuilder prefix, String mid, int size) {
        if (prefix.length() == size) {
            StringBuilder reverse = new StringBuilder(prefix).reverse();
            res.add(prefix.toString() + mid + reverse.toString());
            return;
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            int num = entry.getValue();
            char ch = entry.getKey();
            if (num > 0) {
                prefix.append(ch);
                map.put(ch, num - 1);
                dfsHelper(map, res, prefix, mid, size);
                map.put(ch, num);   // care, should not be num + 1
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }
    
}
// Time: O(n!) Space: O(n)


// time limit exception
class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        if (s.length() == 1) {
            res.add(s);
            return res;
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

        dfsHelper(res, new StringBuilder(), map, s.length());
        return res;
    }
    private void dfsHelper(List<String> res, StringBuilder prefix,
                           Map<Character, Integer> map, int length) {
        if (prefix.length() == (length + 1) / 2) {
            StringBuilder result = new StringBuilder(prefix);
            StringBuilder reverse = new StringBuilder(prefix);
            reverse.reverse();
            if (length % 2 == 1) {
                result.deleteCharAt(result.length() - 1).append(reverse);
            }else {
                result.append(reverse);
            }
            res.add(result.toString());
            return;
        }


        int pos = prefix.length();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (pos != length - 1 - pos) {
                if (entry.getValue() >= 2) {
                    prefix.append(entry.getKey());
                    entry.setValue(entry.getValue() - 2);
                    dfsHelper(res, prefix, map, length);
                    prefix.deleteCharAt(prefix.length() - 1);
                    entry.setValue(entry.getValue() + 2);
                }
            }else {
                if (entry.getValue() == 1) {
                    prefix.append(entry.getKey());
                    entry.setValue(entry.getValue() - 1);
                    dfsHelper(res, prefix, map, length);
                    prefix.deleteCharAt(prefix.length() - 1);
                    entry.setValue(entry.getValue() + 1);
                }
            }
        }
    }
}
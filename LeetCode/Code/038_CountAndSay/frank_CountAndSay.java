class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            String str = "";
            int start = 0;
            for (int j = 0; j < res.length(); j++) {
                if (res.charAt(j) != res.charAt(start)) {
                    str = str + (j - start) + res.charAt(start);
                    start = j;
                }
            }
            str = str + (res.length() - start) + res.charAt(start);
            res = str;   
        }
        return res;
    }
}

/*
    Two pointers
    Time: O(n*K) K is the average of all results lengths
    Space: O(1)
*/
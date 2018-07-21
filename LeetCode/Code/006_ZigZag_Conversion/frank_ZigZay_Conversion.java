class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) { // take care: numRows <= 1
            return s;
        }
        String res = "";
        String[] strs = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            strs[i] = "";
        }
        for (int i = 0; i < s.length(); i++) {
            int index = i % (2 * numRows - 2);
            if (index >= numRows) {
                index = numRows - 1 - (index % (numRows - 1));
            }
            strs[index] += s.charAt(i);
        }
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }
}


/*
	Time: O(n)    Space: O(K)   K = numRows

	Coner Case:
	"A" 1;  the numRows should > 1 in above algrothm 
*/
class Solution {
    public int compareVersion(String version1, String version2) {
        
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while(i < v1.length && i < v2.length) {
            int intStr1 = Integer.valueOf(v1[i]);
            int intStr2 = Integer.valueOf(v2[i]);
            if (intStr1 > intStr2)
                return 1;
            else if (intStr1 < intStr2)
                return -1;
            i++;
        }
        
        if (i < v1.length) {
            while (i < v1.length) {
                if (Integer.valueOf(v1[i]) > 0) {
                    return 1;
                }
                i++;
            }
            return 0;
        }
        
        if (i < v2.length) {
            while (i < v2.length) {
                if (Integer.valueOf(v2[i]) > 0) {
                    return -1;
                }
                i++;
            }
            return 0;
        }
        return 0;
    }
}
/*  Time: O (n)    Space: O(n)
    Split each sections and compare them one by one

*/
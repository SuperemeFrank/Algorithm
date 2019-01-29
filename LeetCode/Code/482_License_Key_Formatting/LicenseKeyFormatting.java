class Solution {
    public String licenseKeyFormatting(String S, int K) {
             
        StringBuilder sb = new StringBuilder();
        int k = K;
        for (int i = S.length() - 1; i >= 0; i--) {
            
            char c = S.charAt(i);
            
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toUpperCase(c));
                k--;
            }
            
            if (k == 0 && i > 0) {
                sb.append("-");
                k = K;
            }            
        }
        
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.setLength(sb.length() - 1);
        }
        
        return sb.reverse().toString();
    }
}

//Time: O(n)  Space: O(n)
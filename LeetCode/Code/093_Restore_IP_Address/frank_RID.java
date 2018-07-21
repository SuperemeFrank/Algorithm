class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        helper(s, res, "", 4);
        return res;
    }
    
    public void helper (String s, List<String> res, String ipAdd, int count) {  // count the part of combined IP
        if (count == 0 && s.length() == 0) {
            res.add(ipAdd.substring(0, ipAdd.length() - 1));                 // cut the last '.'
        }
        
        for (int i = 0; i < 3; i ++) {                                      //each part have no more than 3 digits
            if (s.length() > 0 && s.charAt(0) == '0') {
                ipAdd = ipAdd + "0";
                helper(s.substring(1, s.length()), res, ipAdd + '.', count - 1);
                break;                                                              //first is 0, it should be a whole section
            }else if (i < s.length() && Integer.valueOf(s.substring(0, i + 1)) <= 255) {
                ipAdd = ipAdd + s.charAt(i);
                helper(s.substring(i + 1, s.length()), res, ipAdd + '.', count - 1);
            }
        }
    }
}

//BackStrace, but here we use String so we don't backstrace manually
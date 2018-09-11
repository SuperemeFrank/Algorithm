class Solution {
    public String getHint(String secret, String guess) {
        int Acount = 0;
        int Bcount = 0;
        int[] digitA = new int[10];
        int[] digitB = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                Acount++;
                continue;
            }else {
                int tA = secret.charAt(i) - '0';
                int tB = guess.charAt(i) - '0';
                if (digitB[tA] > 0) {
                    Bcount++;
                    digitB[tA]--;
                }else {
                    digitA[tA]++;
                }
                if (digitA[tB] > 0) {
                    Bcount++;
                    digitA[tB]--;
                }else {
                    digitB[tB]++;
                }
            }
        }
        String res = Acount + "A" + Bcount + "B";
        return res;
    }
}

/* Time: O(n)   Space: O(1)
    two array records the digits in A and in B that are not math in the same position
*/

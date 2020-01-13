class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int carry = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            int cur = A[i];
            res.add((K % 10 + cur + carry) % 10);
            carry = (K % 10 + cur + carry) / 10;
            K = K / 10;
        }
        
        while (K != 0) {
            res.add((K % 10 + carry) % 10);
            carry = (K % 10 + carry) / 10;
            K = K / 10;
        }
        
        if (carry != 0) {
            res.add(carry);
        }
        
        Collections.reverse(res);
        return res;
    }
}

/*
    Time: O(max(m, n)) m is the digits of K, n is the length of A
    Space: O(1)

*/
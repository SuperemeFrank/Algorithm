class Solution {
    public int[] sortedSquares(int[] A) {
        
        int k = 0;
        while (k < A.length && A[k] <= 0) {
            k++;
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        
        return merge(A, k);
    }
    private int[] merge(int[] A, int k) {
        int[] res = new int[A.length];
        int i = k - 1;
        int j = k;
        int cur = 0;
        while (i >= 0 && j < A.length) {
            if (A[i] < A[j]) {
                res[cur++] = A[i];
                i--;
            }else {
                res[cur++] = A[j];
                j++;
            }
        }
        
        while (i >= 0) {
            res[cur++] = A[i];
            i--;
        }
        
        while (j < A.length) {
            res[cur++] = A[j];
            j++;
        }
        
        return res;
    }
    
    
}

/*
    Time: O(n)  Space: O(1)

*/
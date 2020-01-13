class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        int evenSum = 0;
        for (int num : A) {
            if (num % 2 == 0) {
                evenSum += num;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int index = query[1];
            int num = query[0];
            if (A[index] % 2 == 0) {
                evenSum -= A[index];
            }
            int result = A[index] + num;
            A[index] = result;
            if (result % 2 == 0) {
                evenSum += result;
            }
            ans[i] = evenSum;
        }
        
        return ans;
    }
}
/*
    Time: O(N + M) N is A.length, M is queries.length
    Space: O(1)

*/
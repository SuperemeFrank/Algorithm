class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0 ) {
            return new int[0][0];
        }
        int rowA = A.length;
        int colA = A[0].length;
        int rowB = B.length;
        int colB = B[0].length;
        int[][] res = new int[rowA][colB];
        if (colA != rowB) {
            return res;
        }
        
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int x = 0; x < colA; x++) {
                    res[i][j] += A[i][x] * B[x][j];
                }
            }
        }
        return res;
    }
}

/*  Time: O(rowA * colB * colA)  Space: O(1)
    AB = A x B
    ARow ACol BRow BCol      ACol == BRow  results[ARow][BCol]
    
    result[i][j] = A[i][:] * B[:][j]

*/
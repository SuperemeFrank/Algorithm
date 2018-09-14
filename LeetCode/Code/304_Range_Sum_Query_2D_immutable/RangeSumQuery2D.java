class NumMatrix {
    int[][] preSum;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;  
        }
        preSum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < preSum.length; i++) {
            int lineSum = 0;
            for (int j = 0; j < preSum[0].length; j++) {
                lineSum += matrix[i][j];
                if (i > 0) {
                    preSum[i][j] = preSum[i - 1][j] + lineSum;
                }else {
                    preSum[i][j] = lineSum;
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int sum = preSum[row2][col2];
        if (row1 > 0) {
            sum -= preSum[row1 - 1][col2];
        }
        if (col1 > 0) {
            sum -= preSum[row2][col1 - 1];
        }
        if (row1 > 0 && col1 > 0) {
            sum += preSum[row1 - 1][col1 - 1];
        }
        return sum;
    }
}

/** amorted Time: O(1)
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
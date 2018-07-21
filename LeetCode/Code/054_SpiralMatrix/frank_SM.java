class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if( matrix.length == 0 || matrix == null || matrix[0] == null || matrix[0].length == 0){
            return res;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int i = colBegin; i <= colEnd; i++){
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for(int i = rowBegin; i <= rowEnd; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if(rowBegin <= rowEnd){       //should confirm rowBegin <= rowEnd
                for(int i = colEnd; i >= colBegin; i--){
                    res.add(matrix[rowEnd][i]);
                }
                
            }
            rowEnd--;
            if(colBegin <= colEnd){
                for(int i = rowEnd; i >= rowBegin; i--){
                    res.add(matrix[i][colBegin]);
                }
                
            }
            colBegin++;
        }
        return res;
    }
}



// recursion (same idea: print the outter boundary, and the rest is a subProblem)

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // TODO: Corner case
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        printSpiral(matrix, res, 0, matrix[0].length - 1, matrix.length - 1, 0);
        return res;
    }
    
    public void printSpiral(int[][] matrix, List<Integer> res, int topBond, 
                       int rightBond, int bottomBond, int leftBond) {
        if (topBond > bottomBond || leftBond > rightBond) {
            return;
        }
        
        for (int i = leftBond; i <= rightBond; i++) {
            res.add(matrix[topBond][i]);
        }
        topBond ++;
        for (int j = topBond; j <= bottomBond; j++) {
            res.add(matrix[j][rightBond]);
        }
        rightBond--;
        if (topBond > bottomBond || leftBond > rightBond) {
            return;
        }
        for (int i = rightBond; i >= leftBond; i--) {
            res.add(matrix[bottomBond][i]);
        }
        bottomBond--;
        for (int j = bottomBond; j >= topBond; j--) {
            res.add(matrix[j][leftBond]);
        }
        leftBond++;
        printSpiral(matrix, res, topBond, rightBond, bottomBond, leftBond);
    }
}
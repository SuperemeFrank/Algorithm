class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int up = 0, down = n - 1;
        while(up + 1 < down) {
            int mid = (down - up)/2 + up;
            if(matrix[mid][m - 1] < target) {
                up = mid;
            }else {
                down = mid;
            }
        }
        int row = matrix[up][m - 1] >= target ? up : down; // in case [[1],[2]]
        int left = 0, right = m - 1;
        while(left + 1 < right) {
            int mid = (right - left)/2 + left;
            if (matrix[row][mid] == target) {
                right = mid;
            }else if(matrix[row][mid] < target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        
        if (matrix[row][left] == target || matrix[row][right] == target) {  // in case [[1]] and [[1,2]]
            return true;
        }
        return false;
        
    }
}

//two dimension binary search
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // TODO: corner case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return helper(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }
    
    private boolean helper(int[][] matrix, int target, 
                          int startRow, int startCol,
                          int endRow, int endCol) {
        if (startRow > endRow || startCol > endCol) {
            return false;
        }
        int midRow = startRow + (endRow - startRow) / 2;
        int midCol = startCol + (endCol - startCol) / 2;
        if (matrix[midRow][midCol] == target) {
            return true;
        }else if (matrix[midRow][midCol] < target) {
            return helper(matrix, target, midRow + 1, startCol, endRow, midCol) ||
                    helper(matrix, target, startRow, midCol + 1, midRow, endCol) ||
                    helper(matrix, target, midRow + 1, midCol + 1, endRow, endCol);
        }else {
            return helper(matrix, target, startRow, startCol, midRow - 1, midCol - 1) ||
                    helper(matrix, target, startRow, midCol, midRow - 1, endCol) ||
                    helper(matrix, target, midRow, startCol, endRow, midCol - 1);
        }

    }
}

// Unknown Time &Space

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}

// Time: O(m+n)  Space: O(1)
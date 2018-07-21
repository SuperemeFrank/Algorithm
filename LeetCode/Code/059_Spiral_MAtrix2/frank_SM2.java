class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            return null;
        }
        int[][] res = new int[n][n];
        int count = 1;
        // four boudary of each iterating 
        int up = 0,left = 0;
        int down = n - 1, right = n - 1;
        int row = up;
        int col = left - 1;
        while(true) {
            
            while (col < right) {
                col ++;
                res[row][col] = count;
                count ++;
            }
            up ++;
            while (row < down) {
                row ++;
                res[row][col] = count;
                count ++;
            }
            right --;
            while (col > left) {
                col --;
                res[row][col] = count;
                count ++;
            }
            down --;
            while (row > up) {
                row --;
                res[row][col] = count;
                count ++;
            }
            left ++;
            //break condition
            if (left > right || up > down) {
                break;
            }
        }
        return res;
    }
}

/** if we vitually build the matrix, the update always follow the four edges of the matrix, 
    and the length of each edge shrink after build it. Thus we know each time we need to build 
    one edge of the matrix.  
    After four edges have been built, it's gonna be a sub problem ot the original which the sub matrix
    we need to build is one smaller than former one
**/
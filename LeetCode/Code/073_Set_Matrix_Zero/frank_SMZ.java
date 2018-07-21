class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < m; i ++) {      //store all the zero positions in stack
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == 0) {
                    stack.push(new Node(i, j));
                }
            }
        }
        
        while (!stack.isEmpty()) {         //set rows and columns of each node zero
            Node node = stack.pop();
            for (int i = 0; i < m; i++) {
                matrix[i][node.col] = 0;
            }
            for (int i = 0; i < n; i++) {
                matrix[node.row][i] = 0;
            }
        }
    }
}

class Node{
    public int row;
    public int col;
    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
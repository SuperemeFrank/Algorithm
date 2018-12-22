class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                }else {
                    heights[j] = 0;
                }
            }
            
            max = Math.max( max, getMaximumRectangle(heights));
        }
        
        return max;
    }
    
    private int getMaximumRectangle(int[] heights) {
        int max = 0;
        int n = heights.length;
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        
        while (i < n) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            }else {
                int tp = stack.pop();
                int area = heights[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                
                max = Math.max(max, area);
            }
        }
        
        while (!stack.isEmpty()) {
            int tp = stack.pop();
            int area = heights[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                
            max = Math.max(max, area);
        }
        return max;
    }
}

/*
    Time: O(n^2)  Space: O(n)

    Treat each subMatrix as a histgram, the problem becomes the same as #84
*/
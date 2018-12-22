class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int i = 0;
        int n = heights.length;
        Deque<Integer> stack = new LinkedList<>();
        while (i < n) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.offerFirst(i++);
            }else {
                int his = stack.peek();
                stack.pop();
                int area = heights[his] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                max = Math.max(max, area);
            }
            
        }
        
        while (!stack.isEmpty()) {
            int his = stack.peek();
            stack.pop();
            int area = heights[his] * (stack.isEmpty() ? n : n - stack.peek() - 1);
            
            max = Math.max(max, area);
        }
        
        return max;
    }
}

/*   Time: O（n）  Space: O(n)
    
    For every bar ‘x’, we calculate the area with ‘x’ as the smallest bar in the rectangle. 
    If we calculate such area for every bar ‘x’ and find the maximum of all areas, our task is done.
    
    So if we meet a bar i that is smaller than the bar m at the top of our stack,
    we use the bar m at the top of the stack as the height of the rectangle.
    We can be sure that the bars between i and m are all no smaller than m. (because if any of them is smaller, the m would be pop from the stack before)
    
    Also we can make sure that the second bar j at the top of stack is the left bound of our rectangle.
    This can be inducted from the rule. Thus the largest rectangle with the bar m can be calculate as heights[m] * (i - j - 1)
    

*/

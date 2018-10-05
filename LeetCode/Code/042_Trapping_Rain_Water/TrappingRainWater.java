class Solution {
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i <= j) {
            if (left <= right) {
                res += Math.max(left - height[i], 0);
                left = Math.max(left, height[i]);
                i++;
            }else {
                res += Math.max(right - height[j], 0);
                right = Math.max(right, height[j]);
                j--;
            }
        }
        return res;
    }
}

/*  Time: O(n)  Space: O(1)
    for a cretain index, the water it can trap is based on the max left and right boundary of it
    so assume the most left and right boundary are 0
    
    we track the boundary of each index from outter to inner
    
    i start from left side, j start from right side
    left and right record the max boundary as we traversed, so i and j should always be in the boundary.
    and i if the left most index that hasn't been visited, j is the right most
    
    we can be sure that the heighr between left and i are all smaller than i
    
    for each time, if left < right, we know that for i, because the right boundary of i must bigger than left,
    so we know i block can track left - height[i] water
    
    the same for j

*/
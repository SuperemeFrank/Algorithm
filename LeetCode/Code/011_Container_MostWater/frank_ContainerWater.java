class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int vol = (right - left) * Math.min(height[left], height[right]);
            max = max > vol ? max : vol;
            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return max;
    }
}

/*
	Time: O(n) Space: O(1)

	Idea: two pointers form edge to center
		  Each loop the smallest height of current container should move center,
		  so that the next container could potientially larger than the current one
*/
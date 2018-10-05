class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int curPos = 0;
        int[] M = new int[n];
        M[0] = 0;
        for (int i = 0; i < n; i++) {
            int postPos = i + nums[i];
            for (int j = curPos + 1; j <= postPos && j < n; j++) {
                M[j] = M[i] + 1;
                curPos = j;
            }
        }
        return M[n - 1];
    }
}


/*  Becase each element in M[] will be only update once, the Time Complexity would be O(n)  Space: O(n)
    M[i] represents the jump to i the minimum steps
    
    a, b are two pointers, if a < b then M[i] <= M[j]
    thus, when we traverse to i, if all i + nums[i] are updated, we don't update them, 
    otherwise only update the unupdated elements

*/

class Solution2 {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] M = new int[n];
        M[0] = 0;
        for (int i = 1; i < n; i++) {
            M[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    M[i] = Math.min(M[i], M[j] + 1);
                }
            }
        }
        return M[n - 1];
    }
}

/*  Time: O(n^2)  Space: O(n)      *****Time exceeded
    M[i] represents the minimum numer of jumps that can jump to pos i
    
    M[i] = for all the j < i, Min{M[j] + 1} where j can jump to i

*/
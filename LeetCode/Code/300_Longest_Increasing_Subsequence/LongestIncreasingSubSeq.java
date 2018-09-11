
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int max = 0;
        int[] M = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            M[i] = 1;
            max = Math.max(M[i], max);
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    M[i] = Math.max(M[i], M[j] + 1);
                    max = Math.max(M[i], max);
                }
            }
        }
        return max;
    }
}

/* Time: O(n ^ 2)  Space: O(n)

    M[i] represents the longest subsequence including i - 1
    M[i] = for j from o to i - 1 && nums[j] < nums[i] -> Max{M[j] + 1}
*/
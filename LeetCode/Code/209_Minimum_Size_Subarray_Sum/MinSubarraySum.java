
// sliding window
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // TODO: coner case
        if (nums == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < nums.length || sum >= s) {
            if (sum < s) {
                sum += nums[j++];
            }else {
                min = min < j - i ? min : j - i;
                sum -= nums[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

// Time: O(2n) ~ O(n)  Space: O(1)

/*
    case 1: sum >= s compare it with min
        1.1: i == j i++ j++
        1.2: i < j i++
    case 2: sum < s j++;
*/
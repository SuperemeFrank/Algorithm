class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int sum = target - nums[i];
            while (k > j) {
                if (nums[k] + nums[j] < sum) {
                    res += k - j;
                    j++;
                }else {
                    k--;
                }
            }
        }
        return res;
    }
}

// Time: O(n^2)    Space: O(1)
/*                 j
            1   3   5    6
         1  //////////////

         3  v   //////////
    k
         5  v   v   /////
                |
         6  7 ->9 -> X //

*/







class Solution2 {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (target <= 3 * nums[i]) {
                break;
            }
            int resSum = target - nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (resSum <= 2 * nums[j]) {
                    break;
                }
                int sum = resSum - nums[j];
                for(int k = j + 1; k < nums.length; k++) {
                    if (nums[k] >= sum) {
                        break;
                    }
                    res++;
                }
            }
        }
        return res;
    }
}


// Time: O(n^3)   Space: O(1)
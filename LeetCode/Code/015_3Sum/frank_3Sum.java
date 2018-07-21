class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }   
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {	// remove duplicates
                int low = i + 1;
                int high = nums.length - 1;
                int target = 0 - nums[i];
                while (low < high) {
                    int sum = nums[low] + nums[high];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {	// remove dupliacates
                            low ++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) { // reomove duplicates
                            high --;
                        }
                        low ++;
                        high --;
                    } else if(sum < target) {
                        low ++;
                    } else {
                        high --;
                    }
                }
            }
        }
        return res;
    }
}

// use three pointers

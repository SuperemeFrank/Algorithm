class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        int i = 0;
        StringBuilder range = new StringBuilder();
        range.append(nums[i]);
        for (int j = 0; j < nums.length; j++) {
            if (j > 0 && nums[j] != nums[j - 1] + 1) {
                if (j - 1 > i) {
                    range.append("->");
                    range.append(nums[j - 1]);
                }
                res.add(range.toString());
                range = new StringBuilder();
                i = j;
                range.append(nums[i]);
            }
            if (j == nums.length - 1) { 
                if (j > i) {
                    range.append("->");
                    range.append(nums[j]);
                }
                res.add(range.toString());
            }
        }
        return res;
    }
}

// Time: O(n), Space: O(n)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int pos = map.get(nums[i]);
                if (Math.abs(i - pos) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}

// Time: O(n) Space: O(n)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0 || t < 0) {
            return false;
        }
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long mapNum = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = mapNum / ((long)t + 1);
            if (map.containsKey(bucket) ||
                    map.containsKey(bucket - 1) && nums[i] - map.get(bucket - 1) <= t ||
                    map.containsKey(bucket + 1) && map.get(bucket + 1) - nums[i] <= t) {
                return true;
            }
            
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long)nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, (long)nums[i]);
        }
        return false;
    }
}

// Time: O(n)  Space: O(k)
// idea: its like a sliding window, the k restricts the length of the window, we use buckets to treat numbers
// whose difference in range is with in t
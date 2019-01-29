class Solution {
    public int subarraySum(int[] nums, int k) {
        
        if (nums == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        for (int num : nums) {
            prefixSum += num;
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            if (prefixSum == k) {
                count++;
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }
}


/*  Time: O(n)  Space: O(n)
    similar to twoSum,
    
    use a hashMap to store the current prefix sum, and the number of its existence
    
    for each time when we get the current prefixSum, check if prefixSum - k exists in previous, and count there times

*/
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int tmp : nums) {
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i > 0; i--) {
            if (bucket[i] == null) continue;
            for (int top : bucket[i]) {
                res.add(top);
                if (res.size() == k) return res;
            }
        }
        return res;
    }
}

/*  Time: O(n)  Space: O(n)
    bucket sort,
    use hashMap to store the frequency of each unique element
    bucket[i] represents the element that appear i times in the array
    each bucket should store a arraylist in case multi elements exist same times
*/


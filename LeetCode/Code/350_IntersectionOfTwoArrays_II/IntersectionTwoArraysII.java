class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] smallerNums = nums1.length < nums2.length ? nums1 : nums2;
        int[] biggerNums = nums1.length < nums2.length ? nums2 : nums1;
        
        for (int num : smallerNums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> temper = new ArrayList<>();
        for (int num : biggerNums) {
            if (map.containsKey(num) && map.get(num) != 0) {
                temper.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        
        int[] res = new int[temper.size()];
        for (int i = 0; i < temper.size(); i++) {
            res[i] = temper.get(i);
        }
        
        return res;
    }
}


/*  Time: O(max(n, m)) Space: O(min(n, m))
    same with the previous one, but use a hashmap to count the number of elements in the List


*/
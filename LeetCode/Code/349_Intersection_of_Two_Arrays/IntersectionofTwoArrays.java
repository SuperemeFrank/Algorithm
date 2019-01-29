class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        List<Integer> temperList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                temperList.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        
        int[] res = new int[temperList.size()];
        for (int i = 0; i < temperList.size(); i++) {
            res[i] = temperList.get(i);
        }
        
        return res;
    }
}


/*  Time: O(n + m)  Space: O(n) -> can be O(min(n, m))
    use set to store one of the array.
    then traverse another one, for each time get an element that is included in the set,
    add it to the result list, then delete it from the set


*/
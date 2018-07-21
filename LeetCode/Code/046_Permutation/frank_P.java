class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(nums, res, new ArrayList<Integer>());
        return res;
    }
    
    public void helper(int[] nums, List<List<Integer>> res, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));  //care, create new ArrayList
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {   // O(n) bad 
                continue;
            }
            list.add(nums[i]);
            helper(nums, res, list);
            list.remove(list.size() - 1);   //traceBack
        }
    }
}

// Time: O(n! * n) Space: O(n)

class Solution2 {  // SWAP
    public List<List<Integer>> permute(int[] nums) {
        
        if (nums == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfsHelper(res, nums, new ArrayList<>(), 0);
        return res;
    }
    
    public void dfsHelper(List<List<Integer>> res, int[] nums, List<Integer> list, int pos) {
        if (pos == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = pos; i < nums.length; i++) {
            swap(nums, pos, i);
            list.add(nums[pos]);
            dfsHelper(res, nums, list, pos + 1);
            list.remove(list.size() - 1);
            swap(nums, pos, i);
        }
    }
    
    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
// Time: O(n!) Space: O(n)
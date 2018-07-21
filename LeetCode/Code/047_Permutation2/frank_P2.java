class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);                              //must be sorted for Remove Duplication
        int[] visited = new int[nums.length];       
        helper(nums, res, new ArrayList<Integer>(), visited);
        return res;
    }
    
    public void helper(int[] nums, List<List<Integer>> res, ArrayList<Integer> list, int[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
             if (visited[i] == 1) {                 // if Array allows Duplication, visited[] should be used instead of "list.contains(nums[i])""
                 continue;
             }
            if (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) { //omit repeatition
                continue;
            }
            list.add(nums[i]);
            visited[i] = 1;
            helper(nums, res, list, visited);
            list.remove(list.size() - 1);          //traceBack
            visited[i] = 0;
        }
    }
}
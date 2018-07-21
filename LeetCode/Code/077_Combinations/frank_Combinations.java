class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n) {
            return res;
        }
        helper(res, n, k, new ArrayList<Integer>(), 1);
        return res;
    }
    //pick one number of the rest into the combination
    public void helper(List<List<Integer>> res, int nums, int comNums, ArrayList<Integer> resList, int start) {
        if (comNums <= 0) {                         //use comNums to count the combination
            res.add(new ArrayList<Integer>(resList));
            return;
        }     
        for (int i = start; i <= nums; i ++ ) {
            if (resList.contains(i)){
                continue;
            }
            resList.add(i);
            helper(res, nums, comNums - 1, resList, i + 1);
            resList.remove(resList.size() - 1);             //backtrace
        }
    }
}


// The follow up of combinations, take care [1,2] and [2,1] are the same
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // TODO: corner case
        
        List<List<Integer>> res = new ArrayList<>();
        dfsHelper(res, k, n, 1, new ArrayList<>());
        return res;
    }
    
    private void dfsHelper(List<List<Integer>> res, int k, int n, 
                           int start, List<Integer> list) {
        if (n < start) {
            return;
        }
        if (k == 1 && n <= 9) {
            list.add(n);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            list.add(i);
            dfsHelper(res, k - 1, n - i, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}

// Time: O(9^n) Space:O(n)
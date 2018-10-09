class Solution {
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        dfsHelper(res, new ArrayList<>(), n);
        
        for (List<Integer> solv : res) {
            List<String> strList = new ArrayList<>();
            for (int i = 0; i < solv.size(); i++) {
                StringBuilder prefix = new StringBuilder();
                int pos = solv.get(i);
                for (int j = 0; j < n; j++) {
                    if (j == pos) {
                        prefix.append('Q');
                    }else {
                        prefix.append('.');
                    }
                }
                strList.add(prefix.toString());
            }
            result.add(new ArrayList<>(strList));
        }
        
        return result;
    }
    
    private void dfsHelper(List<List<Integer>> res, List<Integer> list, int n) {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!checkAttack(list, i)) {
                list.add(i);
                dfsHelper(res, list, n);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean checkAttack(List<Integer> list, int pos) {
        int curRow = list.size();
        
        for (int i = 0; i < list.size(); i++) {
            int preRow = i;
            int prePos = list.get(i);
            if ((Math.abs(preRow - curRow) == Math.abs(prePos - pos)) || prePos == pos) {
                return true;
            }
        }
        return false;
    }
}

/*  Time: O(n^n)   Space: O(n)
    each row can only have one queue
    
    dfs
                        ''
                     / | |||\
0                  0  1 2 3 4 5...

    each level represents one row, there will be n levels
    each level have n branches.
    
    check if the current q will be attack by previous queues.
*/
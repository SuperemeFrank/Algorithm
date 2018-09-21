/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        bfsHelper(root, map);
        int minVi = Integer.MAX_VALUE;
        for (int i : map.keySet()) {
            minVi = Math.min(i, minVi);
        }        
        while (map.containsKey(minVi)) {
            res.add(map.get(minVi++));
        }
        return res;
    }
    
    private void bfsHelper(TreeNode root, Map<Integer, List<Integer>> map) {
        
        Queue<Cell> q = new LinkedList<>();
        q.offer(new Cell(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Cell cur = q.poll();
                List<Integer> list = map.get(cur.vi);
                list = list == null ? new ArrayList<>() : list;
                list.add(cur.node.val);
                map.put(cur.vi, list);
                if (cur.node.left != null) {
                    q.offer(new Cell(cur.node.left, cur.vi - 1));
                }
                
                if (cur.node.right != null) {
                    q.offer(new Cell(cur.node.right, cur.vi + 1));
                }
            }
        }
    }
    
    protected class Cell{
        TreeNode node;
        int vi;
        public Cell(TreeNode node, int vi) {
            this.node = node;
            this.vi = vi;
        }
    }
    
}
/*  Time: O(n)  Space: O(n) n is the number of nodes
    the same idea as below, because we need to follow top-down and left-right order, we have to use BFS instead of DFS
*/

//failed, it generate vertical order, but not follow top-down order
class Solution2 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfsHelper(root, map, 0);
        int minVi = Integer.MAX_VALUE;
        for (int i : map.keySet()) {
            minVi = Math.min(i, minVi);
        }        
        while (map.containsKey(minVi)) {
            res.add(map.get(minVi++));
        }
        return res;
    }
    
    private void dfsHelper(TreeNode root, Map<Integer, List<Integer>>map, int curVi) {
        if (root == null) {
            return;
        }
        List<Integer> list = map.get(curVi);
        list = list == null ? new ArrayList<>() : list;
        list.add(root.val);
        map.put(curVi, list);        
        dfsHelper(root.left, map, curVi - 1);
        dfsHelper(root.right, map, curVi + 1);
    }
}

/*
    the vertical index(vi) of root is 0;
    the vi of the left child of a node is (rootVi - 1), right child is (rootVi + 1);
    use a hashMap to put all the nodes with same vi in a list
    iterate all the key value pair ascendingly and add to the res
*/
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Cell>> map = new HashMap<>();
        Queue<Cell> q = new LinkedList<>();
        Integer smallestX = 0;
        List<List<Integer>> res = new ArrayList<>();
        q.offer(new Cell(root, 0, 0));
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Cell cur = q.poll();
                if (!map.containsKey(cur.X)) {
                    map.put(cur.X, new ArrayList<>());
                }
                List<Cell> curList = map.get(cur.X);
                curList.add(cur);
                smallestX = smallestX < cur.X ? smallestX : cur.X;
                if (cur.node.left != null) {
                    q.offer(new Cell(cur.node.left, cur.X - 1, cur.Y - 1));
                }
            
                if (cur.node.right != null) {
                    q.offer(new Cell(cur.node.right, cur.X + 1, cur.Y - 1));
                }
            }
        }
        
        while (map.containsKey(smallestX)) {
            List<Cell> list = map.get(smallestX);
            Collections.sort(list, new Comparator<Cell>() {
               @Override
                public int compare (Cell c1, Cell c2) {
                    if (c1.X == c2.X) {
                        if (c1.Y == c2.Y) {
                            if (c1.node.val == c2.node.val) return 0;
                            return c1.node.val < c2.node.val ? -1 : 1;
                        }else {
                            return c1.Y > c2.Y ? -1 : 1;
                        }
                    }else {
                        return c1.X < c2.X ? -1 : 1;
                    }
                }
            });
            List<Integer> curResList = new ArrayList<>();
            for (Cell c : list) {
                curResList.add(c.node.val);
            }
            res.add(curResList);
            smallestX++;
        }
        return res;
    }
    
    class Cell {
        TreeNode node;
        int X;
        int Y;
        public Cell(TreeNode node, int X, int Y) {
            this.node = node;
            this.X = X;
            this.Y = Y;
        }
    }
}


/*
    Time: O(nlog)
    Space: O(n)
    
    BFS
    Map (key, value), key corespond to X of each nodes, 
    value is a List<Cell> which contains all the nodes in the of the same X 
    Use a global vale to count the smallest X value.
    
    Nodes might have the same position but different values:
    Sort the List of each level based on X, Y, val
    
    Iterate the levels from the smallest X till the largest.
*/


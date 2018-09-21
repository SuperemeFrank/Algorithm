class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        // add neighbors to each node
        for (int[] line: edges) {
            neighbors.get(line[0]).add(line[1]);
            neighbors.get(line[1]).add(line[0]);
            indegree[line[0]]++;
            indegree[line[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 1) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            res = new ArrayList<>();    // store nodes of each level
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                res.add(node);
                indegree[node]--;
                List<Integer> neighbor = neighbors.get(node);
                for (int nNode: neighbor) {
                    if (indegree[nNode] == 0) {
                        continue;
                    }
                    if (indegree[nNode] == 2) {
                        q.offer(nNode);
                    }
                    indegree[nNode]--;
                }
            }
        }
        return res;
    }
}

/*  Time: O(E)  Space: O(E)
    
    Time: for a tree there are V nodes and V + 1 edges(E), in our algorithm we:
        in mapping neighbors phrase, the Time is O(E)
        in form indegree array phrase, the Time is O(E) ; indegree = 2 * edges
        in BFS phrase, we actually decrease all the indegree, so the Time complexity is O(2E)
        Thus total Time Complexity is O(E)
    
    Space: O(2E) = O(E)  in neighbors phrase, actually we doubled the edges
    
    The answer is the node in the middle of the longest chain
    
    Topo Method
    for each time delete all the nodes whose indegree are 1;
    the only one left is indegree 0, or the only two left linked with each other
    
*/

class Solution2 { // Timeout
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            if (map.containsKey(node1)) {
                map.get(node1).add(node2);
            }else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(node2);
                map.put(node1, tmp);
            }
            
            if (map.containsKey(node2)) {
                map.get(node2).add(node1);
            }else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(node1);
                map.put(node2, tmp);
            }
        }
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = getHeight(i, i, map);
        }
        
        List<Integer> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int num : height){
            min = Math.min(min, num);
        }
        
        for (int i = 0; i < n; i++) {
            if (height[i] == min) {
                res.add(i);
            }
        }
        return res;
    }
    
    private int getHeight(int i, int prev, Map<Integer, List<Integer>> map) {
        List<Integer> neighbors = map.get(i);
        int height = 0;
        for (int node : neighbors) {
            if (node != prev) {
                height = Math.max(height, getHeight(node, i, map));
            }
        }
        return height + 1;
    }
}
// Time: O(V * N)   Space: O(V * N)
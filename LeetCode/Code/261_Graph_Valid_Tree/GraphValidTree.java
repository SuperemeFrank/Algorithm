class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges == null) {
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }
        boolean[][] matrix = new boolean[n][n];
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            matrix[edge[0]][edge[1]] = true;
            matrix[edge[1]][edge[0]] = true;
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int node = q.poll();
            if (visited[node]) {
                return false;
            }
            visited[node] = true;
            for (int i = 0; i < matrix[node].length; i++) {
                if (matrix[node][i]) {
                    matrix[node][i] = false;
                    matrix[i][node] = false;
                    q.offer(i);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
// Time: O(n ^ 2) Space: O(n^2)

/*
    an un-directed graph can be an tree:
        1. no circle 
        2. all nodes connected
*/

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 1) {
            return true;
        }
        if (edges.length != n - 1) {
            return false;
        }
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                return false;
            }
            if (indegree[i] == 1) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            List<Integer> neighbors = map.get(node);
            for (int neighbor : neighbors) {
                if (indegree[neighbor] == 0) {
                    continue;
                }
                if (indegree[neighbor] == 2) {
                    q.offer(neighbor);
                }
                indegree[neighbor]--;
            }
        }
        for (int indeg : indegree) {
            if (indeg != 0) {
                return false;
            }
        }
        return true;
    }
}

/*  Time: O(E)  Space: O(E)2
    To make a valid tree,
    E = V - 1 && no circle in the graph
    
    so we can use topo delete method,
    if the graph E = V - 1, and is not a valid tree. there must exists a circle inside
    so we get the indegree of each node
    delete the nodes whose indegree are 1, and generate new nodes
    BFS
*/

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
// Time: O(V ^ 2) Space: O(V ^ 2)

/*
    an un-directed graph can be an tree:
        1. no circle 
        2. all nodes connected
*/

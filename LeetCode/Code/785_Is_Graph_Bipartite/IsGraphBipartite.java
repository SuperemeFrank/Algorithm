class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            
            if (!dfsHelper(graph, i, visited, 1)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfsHelper(int[][] graph, int node, int[] visited, int group) {
        if (visited[node] != 0) {
            if (visited[node] == group) {
                return true;
            }else {
                return false;
            }
        }
        visited[node] = group;
        int[] neighbors = graph[node];
        int nextGroup = group == 1 ? 2 : 1;
        for (int neighbor : neighbors) {
            if (!dfsHelper(graph, neighbor, visited, nextGroup)) {
                return false;
            }
        }
        
        return true;
    }
}


/*  
    Time: O(V + E)   Space: O(Height + V)
    
    
    use dfs to traverse all the nodes and define the group they should be
    there are only 2 groups, if one node have already been put in group1, and should be also put in group2, it cannot be a bip
    
    visited[i] to track the status of node i; 0 represents not visited, 1 means it has been put in group1, 2 means group2


*/
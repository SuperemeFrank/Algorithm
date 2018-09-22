public class Solution {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {

    List<Integer> res = new ArrayList<>();
    if (n == 1) {
      res.add(0);
      return res;
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
      if (indegree[i] == 1) {
        q.offer(i);
      }
    }
    while (!q.isEmpty()) {
      res = new ArrayList<>();
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int node = q.poll();
        indegree[node]--;
        res.add(node);
        for (int neighbor : map.get(node)) {
          if (indegree[neighbor] == 0) {
            continue;
          }
          if (indegree[neighbor] == 2) {
            q.offer(neighbor);
          }
          indegree[neighbor]--;
        }
      }
    }
    return res;
  }
}

/* Time: O(E) E is the number of edges, Space: O(E)
  Topo decrease
  
  for each nodes, record their neighbors
  also records the indegree of each nodes
  
  for each loop, delete all the nodes whose indegree are 1, and generate new 1 indegree to delete
  the roots should be in the last delete list
*/
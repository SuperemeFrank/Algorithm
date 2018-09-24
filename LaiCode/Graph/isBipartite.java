/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */
public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    for (GraphNode node : graph) {
      if (!isBipartite(node)) {
        return false;
      }
    }
    return true;
  }
  
  private boolean isBipartite(GraphNode root) {
    Set<GraphNode> group1 = new HashSet<>();
    Set<GraphNode> group2 = new HashSet<>();
    Set<GraphNode> visit = new HashSet<>();
    Queue<GraphNode> q = new LinkedList<>();
    q.offer(root);
    group1.add(root);
    
    while (!q.isEmpty()) {
      GraphNode cur = q.poll();
      Set<GraphNode> dif = group1.contains(cur) ? group2 : group1;
      Set<GraphNode> same = group1.contains(cur) ? group1 : group2;
      for (GraphNode neighbor : cur.neighbors) {
        if (same.contains(neighbor)) {
          return false;
        }else {
          if (visit.add(neighbor)) {
            dif.add(neighbor);
            q.offer(neighbor);
          }
        }
      }
    }
    return true;
  }
}

/* Time: O(2E) Space: O(V) 
  two sets for two groups
  two directly linked nodes must be in the different group
  so we generate neigbors for each nodes, 
  if there is a neighbor already in the same group as current, its not a bipartite
  
  to avoid dead loop, we need to record generated nodes
  BFS

*/
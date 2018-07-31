/*
* class GraphNode {
*   public int key;
*   public List<GraphNode> neighbors;
*   public GraphNode(int key) {
*     this.key = key;
*     this.neighbors = new ArrayList<GraphNode>();
*   }
* }
*/
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    Map<GraphNode, GraphNode> map = new HashMap<>();
    List<GraphNode> res = new ArrayList<>();
    for (int i = 0; i < graph.size(); i++) {
      if (!map.containsKey(graph.get(i))) {
        bfsHelper(map, graph.get(i), res);
      }
    }
    return res;
  }
  private void bfsHelper(Map<GraphNode, GraphNode> map,
                        GraphNode head, List<GraphNode> res) {
    Queue<GraphNode> q = new LinkedList<>();
    map.put(head, new GraphNode(head.key));
    q.offer(head);
    while (!q.isEmpty()) {
      GraphNode oldNode = q.poll();
      GraphNode newNode = map.get(oldNode);
      res.add(newNode);
      List<GraphNode> neighbors = oldNode.neighbors;
      for (GraphNode neighbor : neighbors) {
        if (map.containsKey(neighbor)) {
          newNode.neighbors.add(map.get(neighbor));
        }else {
          GraphNode newNeighbor = new GraphNode(neighbor.key);
          q.offer(neighbor);
          map.put(neighbor, newNeighbor);
          newNode.neighbors.add(newNeighbor);
        }
      }
    }
  }
}


/* Time: O(n)  Space: O(n)
          3
        /  \
       4    5
         \ /
     1    2 
     
     corresponding relationship between newNode and oldNode should be mapped
     BFS all the node, expand the current and generate all its neighbors which are not in the map
                       if a neighbor exists in the map, it has been expanded before.
                       
     All the nodes might not be all connected, we use map to check if a not is visited.
       we iterate the graph list:
       if the node is visited, continue
       if not, we generate all the nodes connected with it
*/
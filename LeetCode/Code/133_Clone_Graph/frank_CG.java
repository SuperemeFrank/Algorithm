/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        map.put(node.label, new UndirectedGraphNode(node.label));
        while (!q.isEmpty()) {              
            UndirectedGraphNode dNode = q.poll();
            UndirectedGraphNode newNode = map.get(dNode.label);
            
            if (dNode.neighbors.size() != 0) {
                for (int i = 0; i < dNode.neighbors.size(); i ++) {
                    UndirectedGraphNode neighbor = dNode.neighbors.get(i);
                    if (!map.containsKey(neighbor.label)) {         // 
                        map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                        q.offer(dNode.neighbors.get(i));
                    }
                    newNode.neighbors.add(map.get(neighbor.label));
                }
            }
        }
        
        return map.get(node.label);
    }
}
// Time: O(n*k) k is the average neighbors of a node                  Space: O(n)
// in each BFS, copy neighbors nodes of current old nodes；
// add copy neighbor nodes to current new nodes
// ** if neighbor nodes exist in map, do not add it to queue and create new to map
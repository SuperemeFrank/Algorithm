/**
 * class RandomListNode {
 *   public int value;
 *   public RandomListNode next;
 *   public RandomListNode random;
 *   public RandomListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  public RandomListNode copy(RandomListNode head) {
    if (head == null) {
      return null;
    }
    Queue<RandomListNode> q = new LinkedList<>();
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode newHead = new RandomListNode(head.value);
    map.put(head, newHead);
    q.offer(head);
    while (!q.isEmpty()) {
      RandomListNode oldNode = q.poll();
      RandomListNode newNode = map.get(oldNode);
      if (oldNode.next != null) {
        if (!map.containsKey(oldNode.next)) {
          q.offer(oldNode.next);
          RandomListNode newNext = new RandomListNode(oldNode.next.value);
          newNode.next = newNext;
          map.put(oldNode.next, newNext);
        }else {
          newNode.next = map.get(oldNode.next);
        }
      }
      if (oldNode.random != null) {
        if (!map.containsKey(oldNode.random)) {
          q.offer(oldNode.random);
          RandomListNode newRandom = new RandomListNode(oldNode.random.value);
          newNode.random = newRandom;
          map.put(oldNode.random, newRandom);
        }else {
          newNode.random = map.get(oldNode.random);
        }
      }
    }
    return newHead;
  }
}


/* Time: O(n) Space: O(n)
  2 -> 3 -> 4 -> 5
  |    ^
  |____|
    
  1. map the corresponding relationship between oldNode and newNode
  2. BFS, expand current node:
    if node.next not in map, generate new and  link them
    if node.random not in map, generate new and link them
*/
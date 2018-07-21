/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode oldNode = head;
        Map<Integer, RandomListNode> map = new HashMap<>();
        while (oldNode != null) {                   // copy all nodes
            map.put(oldNode.label, new RandomListNode(oldNode.label));
            oldNode = oldNode.next;
        }
        
        oldNode = head;
        while(oldNode != null) {            // copy the relationship of each nodes
            RandomListNode newNode = map.get(oldNode.label);
            if (oldNode.next != null) {
                newNode.next = map.get(oldNode.next.label);
            }
            
            if (oldNode.random != null) {
                newNode.random = map.get(oldNode.random.label);
            }
            oldNode = oldNode.next;
        }
        return map.get(head.label);
    }
}


//Time: O(n)  Space: O(n) the map
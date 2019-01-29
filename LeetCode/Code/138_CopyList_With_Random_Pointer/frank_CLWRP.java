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
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        Queue<RandomListNode> q = new LinkedList<>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        q.offer(head);
        while (!q.isEmpty()) {
            RandomListNode cur = q.poll();
            RandomListNode curNew = map.get(cur);
            if (cur.next != null) {
                if (!map.containsKey(cur.next)) {
                    RandomListNode newNext = new RandomListNode(cur.next.label);
                    curNew.next = newNext;
                    map.put(cur.next, newNext);
                    q.offer(cur.next);
                }else {
                    RandomListNode newNext = map.get(cur.next);
                    curNew.next = newNext;
                }
            }
            
            if (cur.random != null) {
                if (!map.containsKey(cur.random)) {
                    RandomListNode newRandom = new RandomListNode(cur.random.label);
                    curNew.random = newRandom;
                    map.put(cur.random, newRandom);
                    q.offer(cur.random);
                }else {
                    RandomListNode newRandom = map.get(cur.random);
                    curNew.random = newRandom;
                }
            }
        }
        
        return newHead;
    }
}


/*
    use a Map to mapping the old nodes and their corresponding new nodes
    BFS and copy all the nodes

*/

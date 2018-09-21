/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> flatNest;
    Iterator<Integer> iter;
    public NestedIterator(List<NestedInteger> nestedList) {
        flatNest = new ArrayList<>();
        flattenList(flatNest, nestedList);
        iter = flatNest.iterator();
    }
    
    private void flattenList(List<Integer> flat, List<NestedInteger> nest) {
        if (nest == null) {
            return;
        }
        for (int i = 0; i < nest.size(); i++) {
            if (nest.get(i).isInteger()) {
                flat.add(nest.get(i).getInteger());
            }else {
                flattenList(flat, nest.get(i).getList());
            }
        }
    }
    
    @Override
    public Integer next() {
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }
}

/*  Time:                   Space:
    NestedIterator- O(n)    O(n)
    next()          O(1)    O(1)
    hasNext()       O(1)    O(1)
    
    amortized Time: O(1)

    DFS to traverse all the nodes and record them in a List<Integer>
    just use the Iterator of the new List
*/


/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
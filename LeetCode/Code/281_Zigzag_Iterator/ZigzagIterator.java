public class ZigzagIterator {
    int another;
    int cur;
    List<Integer> curList;
    List<Integer> anotherList;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        cur = 0;
        another = 0;
        curList = v2;
        anotherList = v1;
    }

    public int next() {
        int res = curList.get(cur);
        cur++;
        return res;
    }

    public boolean hasNext() {
        if (cur >= curList.size() && another >= anotherList.size()) {
            return false;
        }
        
        if (another < anotherList.size()) {
            int tmp = cur;
            List<Integer> tmpList = curList;
            cur = another;
            curList = anotherList;
            another = tmp;
            anotherList = tmpList;
        }
        return true;
    }
}

/*
    average time: O(1)  Space: O(1)
*/

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
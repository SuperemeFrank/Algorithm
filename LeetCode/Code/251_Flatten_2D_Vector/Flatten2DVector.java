public class Vector2D implements Iterator<Integer> {
    private List<List<Integer>> vec;
    Iterator<List<Integer>> rowIter;
    Iterator<Integer> colIter;
    public Vector2D(List<List<Integer>> vec2d) {
        vec = new ArrayList<>();
        for (List<Integer> l : vec2d) {
            vec.add(new ArrayList<>(l));
        } 
        if (vec2d != null) {
                rowIter = vec.iterator();
            if (rowIter.hasNext()) {
                colIter = rowIter.next().iterator();
            }
        }
       
    }

    @Override
    public Integer next() {
        if (colIter.hasNext()) {
            return colIter.next();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (colIter == null) {
            return false;
        }
        if (!colIter.hasNext()) {
            if (rowIter.hasNext()) {
                List<Integer> list = rowIter.next();
                while (list.size() == 0 && rowIter.hasNext()) {
                    list = rowIter.next();
                }
                if (list.size() == 0) {
                    return false;
                }else {
                    colIter = list.iterator();
                }
            }else {
                return false;
            }
        }
        return true;
    }
}

/*
    corner case:
    [[1], []];
    [[1], [], [1,2,3]]
    [[], [1]]
    
*/


/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
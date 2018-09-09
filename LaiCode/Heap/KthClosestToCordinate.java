public class Solution {
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    int aMin = 0;
    int bMin = 0;
    int cMin = 0;
    for (int i = 1; i < a.length; i++) {
      aMin = Math.abs(a[i]) < Math.abs(a[aMin]) ? i : aMin;
    }
    for (int i = 1; i < b.length; i++) {
      bMin = Math.abs(b[i]) < Math.abs(b[bMin]) ? i : bMin;
    }
    for (int i = 1; i < c.length; i++) {
      cMin = Math.abs(c[i]) < Math.abs(c[cMin]) ? i : cMin;
    }
    
    PriorityQueue<Cell> minHeap = new PriorityQueue<>(new Comparator<Cell>(){
      @Override
      public int compare(Cell c1, Cell c2) {
        if (c1.dist == c2.dist) return 0;
        return c1.dist < c2.dist ? -1 : 1;
      }
    });
    
    Set<Cell> visited = new HashSet<>();
    Cell mC = new Cell(aMin, bMin, cMin, getDist(a[aMin], b[bMin], c[cMin]));
    minHeap.offer(mC);
    visited.add(mC);
    
    for (int i = 0; i < k - 1; i++) {
      Cell cur = minHeap.poll();
      int aP = cur.a;
      int bP = cur.b;
      int cP = cur.c;
      if (aP + 1 < a.length) {
        Cell tmp = new Cell(aP + 1, bP, cP, getDist(a[aP + 1], b[bP], c[cP]));
        if (visited.add(tmp)) {
          minHeap.offer(tmp);
        }
      }
      if (bP + 1 < b.length) {
        Cell tmp = new Cell(aP, bP + 1, cP, getDist(a[aP], b[bP + 1], c[cP]));
        if (visited.add(tmp)) {
          minHeap.offer(tmp);
        }
      }
      if (cP + 1 < c.length) {
        Cell tmp = new Cell(aP, bP, cP + 1, getDist(a[aP], b[bP], c[cP + 1]));
        if (visited.add(tmp)) {
          minHeap.offer(tmp);
        }
      }
      if (aP - 1 >= 0) {
        Cell tmp = new Cell(aP - 1, bP, cP, getDist(a[aP - 1], b[bP], c[cP]));
        if (visited.add(tmp)) {
          minHeap.offer(tmp);
        }
      }
      if (bP - 1 >= 0) {
        Cell tmp = new Cell(aP, bP - 1, cP, getDist(a[aP], b[bP - 1], c[cP]));
        if (visited.add(tmp)) {
          minHeap.offer(tmp);
        }
      }
      if (cP - 1 >= 0) {
        Cell tmp = new Cell(aP, bP, cP - 1, getDist(a[aP], b[bP], c[cP - 1]));
        if (visited.add(tmp)) {
          minHeap.offer(tmp);
        }
      }
    }
    Cell res = minHeap.poll();
    List<Integer> result = new ArrayList<>();
    result.add(a[res.a]);
    result.add(b[res.b]);
    result.add(c[res.c]);
    return result;
  }
  
  private double getDist(int x, int y, int z) {
    return Math.sqrt(x * x + y * y + z * z);
  }
  
  class Cell {
    int a;
    int b;
    int c;
    double dist;
    public Cell(int x, int y, int z, double dist) {
      this.a = x;
      this.b = y;
      this.c = z;
      this.dist = dist;
    }
    public int hashCode() {
      return a*b*c*(int)dist;
    }
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      Cell other = (Cell)obj;
      return (other.a == a && other.b == b && other.c == c);
    }
  }
}

/* Time: O(klogk)  Space: O(k)
  minHeap, each time expand the current smallest element
  use Set to de-duplicate
  we just compare a*a + b*b + c*c

  1. find the closest coordinate (a b c are all closest to 0)
  2. expand it through left and right, (6 expansion)
  3. pick the closest one and de-duplicate

a  -2 -1 1 3
b  -3 -2 1 4
c  -3 -2 2 3
*/
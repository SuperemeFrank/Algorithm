public class Solution {
  public long kth(int k) {
    
    PriorityQueue<Long> minHeap = new PriorityQueue<>();
    Set<Long> visited = new HashSet<>();
    minHeap.offer(3 * 5 * 7L);
    visited.add(3 * 5 * 7L);
    for (int i = 0; i < k - 1; i++) {
      Long current = minHeap.poll();
      if (visited.add(3 * current)) {
        minHeap.offer(3 * current);
      }
      if (visited.add(5 * current)) {
        minHeap.offer(5 * current);
      }
      if (visited.add(7 * current)) {
        minHeap.offer(7 * current);
      }
    }
    return minHeap.poll();
  }
}

/*Time: O(klogk)  Space: O(k)
  because 3, 5, 7 are all prime number, we can make sure that there are no common mutiple number 
  so we can use the product as key, and the idea is the same as Solution2
*/

class Solution2{
  public long kth(int k) {

    Set<Cell> visited = new HashSet<>();
    PriorityQueue<Cell> minHeap = new PriorityQueue<>(3 * k, new Comparator<Cell>() {
      public int compare(Cell c1, Cell c2) {
        long first = (long)(Math.pow(3, c1.x) * Math.pow(5, c1.y) * Math.pow(7, c1.z));
        long second = (long)(Math.pow(3, c2.x) * Math.pow(5, c2.y) * Math.pow(7, c2.z));
        if (first == second) return 0;
        return first < second ? -1 : 1;
      }
    });
    minHeap.offer(new Cell(1, 1, 1));
    visited.add(new Cell(1, 1, 1));
    
    for (int i = 0; i < k - 1; i++) {
      Cell current = minHeap.poll();
      Cell xCell = new Cell(current.x + 1, current.y, current.z);
      Cell yCell = new Cell(current.x, current.y + 1, current.z);
      Cell zCell = new Cell(current.x, current.y, current.z + 1);
      if (visited.add(xCell)) {
        minHeap.offer(xCell);
      }
      if (visited.add(yCell)) {
        minHeap.offer(yCell);
      }
      if (visited.add(zCell)) {
        minHeap.offer(zCell);
      }
    }
    Cell kCell = minHeap.poll();
    return (long)(Math.pow(3, kCell.x) * Math.pow(5, kCell.y) * Math.pow(7, kCell.z));
  }
  
  class Cell {
    int x;
    int y;
    int z;
    public Cell(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }
    
    public int hashCode() {
      return x * y * z;
    }
    
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      Cell other = (Cell)obj;
      if (other.x == x && other.y == y && other.z == z) {
        return true;
      }
      return false;
    }
  }
}

/* 
  minHeap to store the product, 
  each time poll the current smallest one and expand it in 3 cases: x + 1; y + 1; z + 1;
  

*/
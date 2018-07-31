public class Solution {
  public int[] merge(int[][] arrayOfArrays) {
    if (arrayOfArrays.length == 0) {
      return new int[0];
    }
    int k = arrayOfArrays.length;
    PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>(){
      @Override
      public int compare(Cell c1, Cell c2) {
        if (c1.val == c2.val) {
          return 0;
        }
        return c1.val < c2.val ? -1 : 1;
      }
    });
    for (int i = 0; i < k; i++) {
      int[] array = arrayOfArrays[i];
      if (array.length > 0) {
        minHeap.offer(new Cell(array[0], i, 0));
      }
    }
    List<Integer> resList = new ArrayList<>();
    while (!minHeap.isEmpty()) {
      Cell ele = minHeap.poll();
      resList.add(ele.val);
      if (ele.pos + 1 < arrayOfArrays[ele.arr].length) {
        minHeap.offer(new Cell(arrayOfArrays[ele.arr][ele.pos + 1], ele.arr, ele.pos + 1));
      }
    }
    int[] res = new int[resList.size()];
    for (int i = 0; i < resList.size(); i++) {
      res[i] = resList.get(i);
    }
    return res;
  }
  class Cell {
    int val;
    int arr;
    int pos;
    public Cell(int val, int arr, int pos) {
      this.val = val;
      this.arr = arr;
      this.pos = pos;
    }
  }
}

/* Time: O(nlogn)   Space: O(n) -> can be O(k) is not use List
  to merge K sorted Array, we know that the head element is the smallest
  among a single sorted Array. To merge them in ascending order, each time we 
  need to selecet the smallest element.

  we can maintain a K minHeap, also to keep tracking of each element in Heap, we need a new
  data structure to store Cell(value, arrayNumber, position) -> (val, arr, pos)

*/
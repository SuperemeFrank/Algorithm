public class Solution {
  public int[] largestAndSecond(int[] array) {

    List<Cell> cellList = new ArrayList<>();
    for (int i = 0; i < array.length; i = i + 2) {
      if (i + 1 < array.length) {
        if (array[i] > array[i + 1]) {
          Cell newCell = new Cell(array[i]);
          newCell.list.add(array[i + 1]);
          cellList.add(newCell);
        }else {
          Cell newCell = new Cell(array[i + 1]);
          newCell.list.add(array[i]);
          cellList.add(newCell);
        }
      }else {
        cellList.add(new Cell(array[i]));
      }
    }
    Cell largest = cellList.get(0);
    for (int i = 1; i < cellList.size(); i++) {
      if (cellList.get(i).key > largest.key) {
        cellList.get(i).list.add(largest.key);
        largest = cellList.get(i);
      }else {
        largest.list.add(cellList.get(i).key);
      }
    }
    int[] res = new int[2];
    res[0] = largest.key;
    res[1] = Integer.MIN_VALUE;
    for (int e : largest.list) {
      res[1] = res[1] > e ? res[1] : e;
    }
    return res;
  }
  
  class Cell {
    private int key;
    private List<Integer> list;
    public Cell(int key) {
      this.key = key;
      list = new ArrayList<>();
    }
  }
}

/* 
                                     1 2   6 5   8 9  4 3
pair compare                        2[1]   6[5]  9[8] 4[3]             n/2
pair compare again                     6[5 2]
                                             9[8, 6]                    
                                                  9[8, 6, 4]            n/2        
the largest is 9, then find the second largest in list                 logn                                

the total compare: n + logn
*/
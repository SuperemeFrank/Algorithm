public class Solution {
  public int maxTrapped(int[][] matrix) {
    
    int M = matrix.length;
    int N = matrix[0].length;
    boolean[][] visited = new boolean[M][N];
    Queue<Cell> minHeap = new PriorityQueue<>(11, new Comparator<Cell>(){
      @Override
      public int compare(Cell c1, Cell c2) {
        if (c1.level == c2.level) return 0;
        return c1.level < c2.level ? -1 : 1;
      }
    });
    
    for (int i = 0; i < M; i++) {
      minHeap.offer(new Cell(i, 0, matrix[i][0]));
      minHeap.offer(new Cell(i, N - 1, matrix[i][N - 1]));
      visited[i][0] = true;
      visited[i][N - 1] = true;
    }
    
    for (int j = 1; j < N - 1; j++) {
      minHeap.offer(new Cell(0, j, matrix[0][j]));
      minHeap.offer(new Cell(M - 1, j, matrix[M - 1][j]));
      visited[0][j] = true;
      visited[M - 1][j] = true;
    }
    
    int sum = 0;
    
    while (!minHeap.isEmpty()) {
      Cell cur = minHeap.poll();
      sum += cur.level - matrix[cur.row][cur.col];
      if (cur.row + 1 < M && !visited[cur.row + 1][cur.col]) {
        int level = Math.max(cur.level, matrix[cur.row + 1][cur.col]);
        minHeap.offer(new Cell(cur.row + 1, cur.col, level));
        visited[cur.row + 1][cur.col] = true;
      }
      if (cur.row - 1 >= 0 && !visited[cur.row - 1][cur.col]) {
        int level = Math.max(cur.level, matrix[cur.row - 1][cur.col]);
        minHeap.offer(new Cell(cur.row - 1, cur.col, level));
        visited[cur.row - 1][cur.col] = true;
      }
      if (cur.col + 1 < N && !visited[cur.row][cur.col + 1]) {
        int level = Math.max(cur.level, matrix[cur.row][cur.col + 1]);
        minHeap.offer(new Cell(cur.row, cur.col + 1, level));
        visited[cur.row][cur.col + 1] = true;
      }
      if (cur.col - 1 >= 0 && !visited[cur.row][cur.col - 1]) {
        int level = Math.max(cur.level, matrix[cur.row][cur.col - 1]);
        minHeap.offer(new Cell(cur.row, cur.col - 1, level));
        visited[cur.row][cur.col - 1] = true;
      }
    }
    return sum;
  }
  
  class Cell {
    int row;
    int col;
    int level;
    public Cell(int row, int col, int level) {
      this.row = row;
      this.col = col;
      this.level = level;
    }
  }
}



/* Time: O(n * m)  Space: O(n * m)
  1. use minHeap to find the minimum board of current boarder P,
  2. generate the adjacent nodes of P
  3. calculate  adjacent nodes and add them to minHeap

*/
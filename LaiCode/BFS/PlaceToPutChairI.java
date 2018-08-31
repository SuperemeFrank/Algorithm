public class Solution {
  public List<Integer> putChair(char[][] gym) {
    final char EQ = 'E';
    final char OB = 'O';
    final char EMP = 'C';
    
    int M = gym.length;
    int N = gym[0].length;
    List<Pair> equips = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (gym[i][j] == EQ) {
          equips.add(new Pair(i, j));
        }
      }
    }
    int[][] costs = new int[M][N];

    // for each equipment get the path from it to all C
    for (Pair eq : equips) {
      int[][] curCost = new int[M][N];
      Queue<Pair> q = new LinkedList<>();
      boolean[][] visited = new boolean[M][N];
      q.offer(eq);
      while (!q.isEmpty()) {
        Pair cur = q.poll();
        if (cur.i + 1 < M && gym[cur.i + 1][cur.j] != OB && !visited[cur.i + 1][cur.j]) {
          curCost[cur.i + 1][cur.j] = curCost[cur.i][cur.j] + 1;
          visited[cur.i + 1][cur.j] = true;
          q.offer(new Pair(cur.i + 1, cur.j));
        }
        if (cur.j + 1 < N && gym[cur.i][cur.j + 1] != OB && !visited[cur.i][cur.j + 1]) {
          curCost[cur.i][cur.j + 1] = curCost[cur.i][cur.j] + 1;
          visited[cur.i][cur.j + 1] = true;
          q.offer(new Pair(cur.i, cur.j + 1));
        }
        if (cur.i - 1 >= 0 && gym[cur.i - 1][cur.j] != OB && !visited[cur.i - 1][cur.j]) {
          curCost[cur.i - 1][cur.j] = curCost[cur.i][cur.j] + 1;
          visited[cur.i - 1][cur.j] = true;
          q.offer(new Pair(cur.i - 1, cur.j));
        }
        if (cur.j - 1 >= 0 && gym[cur.i][cur.j - 1] != OB && !visited[cur.i][cur.j - 1]) {
          curCost[cur.i][cur.j - 1] = curCost[cur.i][cur.j] + 1;
          visited[cur.i][cur.j - 1] = true;
          q.offer(new Pair(cur.i, cur.j - 1));
        }
      }
      
      // add the current cost to total cost of each node
      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          costs[i][j] += curCost[i][j];
        }
      }
    }
    
    int[] res = {-1, -1};
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (res[0] == -1 && gym[i][j] == EMP) {
          res[0] = i;
          res[1] = j;
        }
        if (gym[i][j] == EMP && costs[res[0]][res[1]] > costs[i][j]) {
          res[0] = i;
          res[1] = j;
        }
      }
    }
    List<Integer> result = new ArrayList<>();
    result.add(res[0]);
    result.add(res[1]);
    return result;
  }
  
  private class Pair {
    int i;
    int j;
    public Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }
}

/* Time: O(n^3)  Space: O(n^2)
      C C E
      C C O
      C C E
      1. for each E, calculate the shortest path from it to all C
      2. stack up the costs of all the E
      3. find the shortest path cost
*/
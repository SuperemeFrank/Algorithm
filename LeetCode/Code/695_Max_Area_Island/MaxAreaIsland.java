class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    max = Math.max(max, bfsHelper(grid, i, j));
                }
            }
        }
        
        return max;
    }
    
    private int bfsHelper(int[][] grid, int i, int j) {
        
        int count = 0;
        Queue<Cell> q = new LinkedList<>();
        q.offer(new Cell(i, j));
        while (!q.isEmpty()) {
            Cell cur = q.poll();
            count++;
            int x = cur.i;
            int y = cur.j;
            if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                q.offer(new Cell(x + 1, y));
                grid[x + 1][y] = 0;
            }
            
            if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                q.offer(new Cell(x, y + 1));
                grid[x][y + 1] = 0;
            }
            
            if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                q.offer(new Cell(x - 1, y));
                grid[x - 1][y] = 0;
            }
            
            if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                q.offer(new Cell(x, y - 1));
                grid[x][y - 1] = 0;
            }
        }
        
        return count;
    }
    
    class Cell {
        int i;
        int j;
        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}



/*  Time: O(n * m)  Space: O(n * m)
    get the area of each island and return the max area among them
    traverse the whole 2D array, if meet a 1, use BFS to get the area of it, and turn this island to be 0

*/
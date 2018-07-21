
class Solution {
    public int numIslandsDFS(char[][] grid) {
        int res = 0;
        if(grid == null || grid.length == 0) return res;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    res += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    //DFS*****************************************************************************
    public void dfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
    
    public int numIslands(char[][] grid) {
        int res = 0;
        if(grid == null || grid.length == 0) return res;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    res += 1;
                    bfs(grid, i, j);
                }
            }
        }
        return res;
    }
    //BFS*****************************************************************************
    public void bfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        int n = grid.length;
        int m = grid[0].length;
        Queue<Integer> q = new LinkedList<>();
        int code = i * m + j;
        q.offer(code);
        while(!q.isEmpty()){
            code = q.poll();
            int x = code / m;
            int y = code % m;
            if(x > 0 && grid[x - 1][y] == '1'){
                q.offer((x - 1) * m + y);
                grid[x - 1][y] = '0';
            }
            if(x < n - 1 && grid[x + 1][y] == '1'){
                q.offer((x + 1) * m + y);
                grid[x + 1][y] = '0';
            }
            if(y > 0 && grid[x][y - 1] == '1'){
                q.offer(x * m + y - 1);
                grid[x][y - 1] = '0';
            }
            if(y < m - 1 && grid[x][y + 1] == '1'){
                q.offer(x * m + y + 1);
                grid[x][y + 1] = '0';
            }
        }
    }
}
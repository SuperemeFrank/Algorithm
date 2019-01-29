class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int N = board.length;
        int[] path = new int[N * N + 1];
        boolean[] visited = new boolean[N * N + 1];
        int index = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int y = N - i - 1;
                if (i % 2 == 0) {
                    path[index++] = board[y][j];
                } else {
                    path[index++] = board[y][N - j - 1];
                }
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                
                visited[cur] = true;
                if (cur >= N * N) {
                    return step;
                }
                for (int j = 1; j <=6 && cur + j <= N * N; j++) {
                    int next = path[cur + j] == -1 ? cur + j : path[cur + j];
                    if (visited[next]) {
                        continue;
                    }else {
                        q.offer(next);
                        visited[next] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}



/*  Time: O(N * N)  Space: O(N * N)
    
    flatten this 2D array to 1D
    use BFS to travers, the level of each traverse means the steps we need to take
    

*/
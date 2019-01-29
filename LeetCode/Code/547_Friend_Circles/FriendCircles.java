
class Solution {
    
    class UnionFind {
        int count;
        int[] parent;
        int[] size; // used to keep the tree as flatten as possible
        
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            size = new int[n]; 
            
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        public void union(int i, int j) { // weighted quick union
            int parentI = find(i);
            int parentJ = find(j);
            
            if (parentI == parentJ) {
                return;
            }
            
            if (size[parentI] < size[parentJ]) {
                parent[parentI] =  parentJ;
                size[parentJ] += size[parentI];
            }else {
                parent[parentJ] = parentI;
                size[parentI] += size[parentJ];
            }
            
            count--;
        }
        
        public int find(int i) {
            while (parent[i] != i) {
                parent[i] = parent[parent[i]]; // path compression
                i = parent[i];
            }
            
            return i;
        }
        
        public int count() {
            return count;
        }
    }
    public int findCircleNum(int[][] M) {
        
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        
        return uf.count();
    }
}


/*  
    Weighted Quick Union Find
    Time: O(N + Mlog*N)  Space: O(N)
    
    
    the size[] are used to balanced the tree
*/


class SolutionBFS {
    public int findCircleNum(int[][] M) {
        
        int count = 0;
        for (int i = 0; i < M.length; i ++) {
            for (int j = i; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    bfsHelper(M, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void bfsHelper(int[][] M, int i, int j) {
        
        Queue<Cell> q = new LinkedList<>();
        q.offer(new Cell(i, j));
        while (!q.isEmpty()) {
            Cell cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            M[x][y] = 0;
            M[y][x] = 0;
            for (int m = 0; m < M.length; m++) {
                if (M[y][m] == 1) {
                    q.offer(new Cell(y, m));
                }
            }
        }
    }
    
    class Cell {
        int x;
        int y;
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


/*   Time: O(n * m * m)  Space: O(n * m)   
    bfs for each group, 
    after traverse a relation, turn it into -1 to represents this relation has been traversed

*/
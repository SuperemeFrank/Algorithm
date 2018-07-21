// Topological Sort
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // corner case
        if (prerequisites == null) {
            return true;
        }
        int[] inDegree = new int[numCourses];
        boolean[][] graph = new boolean[numCourses][numCourses]; // store prereq relation, [course][prereq]
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            graph[course][prereq] = true;
            inDegree[prereq] += 1; 
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int course = q.poll();
            for (int i = 0; i < graph[course].length; i++) {
                if (graph[course][i]) {
                    inDegree[i] = inDegree[i] - 1;
                    if (inDegree[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }
        for (int i : inDegree) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
/*
    拓扑排序用途：常用来解决具有依赖关系的有向图问题
                一个有向无环图可以有一个或多个拓扑排序序列
                也可以用来判断有向图是否有环问题
    实现： 1. 记录每一个节点的入度
          2. 用BFS每次将当前入度为0的节点删除，将其加入排序序列中，删除节点相连节点入度减1
          3. 若删除节点相连节点入度变成0， 则加入queue中
          4. 重复直到queue为空
    
    Time: O(n*m + n*m) = O(n*m)     Space: O(n*m + n + n*m) = O(n*m)   n: row   m: col
    
*/


// DFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // corner case
        
        boolean[][] matrix = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            matrix[course][prereq] = true;
        }
        int[] color = new int[numCourses]; // 0 没有访问过，1 访问过本节点， -1 节点及其之后都被访问过
        for (int i = 0; i < numCourses; i++) {
            if (!dfsHelper(color, matrix, i)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean dfsHelper(int[] color, boolean[][] matrix, int startPoint) {
        if (color[startPoint] == 1) { // 如果本节点被访问过则有环
            return false;
        }
        if (color[startPoint] == -1) {
            return true;
        }
        color[startPoint] = 1;
        boolean flag = true;
        for (int i = 0; i < matrix[startPoint].length; i++) {
            if (matrix[startPoint][i]) {
                if(!dfsHelper(color, matrix, i)) {
                    return false;
                }
            }
        }
        color[startPoint] = -1;
        return true;
    }
}

/*
    用dfs访问每一条线路，如果一条线路中某个节点被访问超过1次，则存在环
    若一条线路走完，则其所有节点都标记为-1
    （若2->3->4 2->4 这种情况，则在第一条线路走完时4会被标记为-1）

    Time: O(n*m)    Space:O(n*m)    n:row    m: col  
*/
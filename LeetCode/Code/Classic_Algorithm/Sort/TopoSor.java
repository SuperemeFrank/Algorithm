/*  leetcode 207 Course Schedule

    There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
*/
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

    
*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][1]] += 1; 
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int course = q.poll();
            list.add(course);
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][0] == course) {
                    inDegree[prerequisites[i][1]] -= 1;
                    if (inDegree[prerequisites[i][1]] == 0) {
                        q.offer(prerequisites[i][1]);
                    }
                }
            }
        }
        
        if (list.size() == numCourses) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[res.length - 1 - i] = list.get(i);
            }
            return res;
        }
        return new int[0];
    }
}

// Time: O(n^2) Space: O(n)
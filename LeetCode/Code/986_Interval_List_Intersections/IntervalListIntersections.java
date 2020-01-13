class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> resList = new ArrayList<>();
        //corner case
        if (A.length == 0 || B.length == 0) {
            return new int[0][0];
        }
        int a = 0;
        int b = 0;
        while (a < A.length && b < B.length) {
            if (A[a][0] > B[b][1]) {
                b++;
                continue;
            }
            if (A[a][1] < B[b][0]) {
                a++;
                continue;
            }
            int[] cur = new int[2];
            if (A[a][0] >= B[b][0]) {
                cur[0] = A[a][0];
                if (A[a][1] < B[b][1]) {
                    cur[1] = A[a][1];
                    a++;
                }else {
                    cur[1] = B[b][1];
                    b++;
                }
                
            }else {
                cur[0] = B[b][0];
                if (A[a][1] > B[b][1]) {
                    cur[1] = B[b][1];
                    b++;
                }else {
                    cur[1] = A[a][1];
                    a++;
                }
            }
            resList.add(cur);
        }
        
        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
            
        }
        return res;
    }
}

/*
    Time: O(n + m)
    Space: O(0)

    a point to current handling interval of A,
    b point to current handling interval of B
    
    two possibility when a and b have not intersection:
    1. a.start > b.end
    2. a.end < b.start
    
    otherwise a and b have intersection
    4 kind of intersections:
    1. a.start >= b.start && a.end <= b.end; a++
    2. a.start <= b.end && a.end >= b.end; b++
    3. a.start <= b.start && a.end >= b.start && a.end < b.end; a++;
    4. a.start <= b.start && a.end >= b.end; b++;

*/
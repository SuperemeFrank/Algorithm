/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        boolean[] isCandidate = new boolean[n];
        Arrays.fill(isCandidate, true);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                if (isCandidate[i] && knows(i, j)) {
                    isCandidate[i] = false;
                }
                if (isCandidate[j] && !knows(i, j)) {
                    isCandidate[j] = false;
                }
                
            }
        }
        for (int i = 0; i < n; i++) {
            if (isCandidate[i]) {
                return i;
            }
        }
        return -1;
    }
}
// knows called n^2 times at worst case    Space: O(n)  Time: O(n^2 * knowsTime)

/*
    assume 4 poeple     2 is celecrity   
    if 0 don't knows 1, 1 cannot be the celebrity, 
    if i knows anyone , i cannot be the celebrity,



*/
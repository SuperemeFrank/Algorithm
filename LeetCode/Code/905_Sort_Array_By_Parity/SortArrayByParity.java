class Solution {
    public int[] sortArrayByParity(int[] A) {
        
        int i = 0;
        int j = 0;
        while (j < A.length) {
            if (A[j] % 2 == 0) {
                int tmp = A[j];
                A[j] = A[i];
                A[i] = tmp;
                i++;
            }
            j++;
        }
        return A;
    }
}



/*  Time: O(n)  Space: O(1)
    non-negative
   Given:   1 2 3 4 5
    
    Return: 2 4 | 1 3 5

    two pointers
    i j
    
    the left of i are all even elements, j is the current processing pointer
*/
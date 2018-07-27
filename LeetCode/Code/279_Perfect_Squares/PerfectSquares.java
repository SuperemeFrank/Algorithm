class Solution {
    public int numSquares(int n) {
        
        int[] calculate = new int[n + 1];
        calculate[1] = 1;
        for (int i = 2; i <= n; i++) {
            calculate[i] = i;
            for (int j = 1; j * j <= i; j++) {
                calculate[i] = Math.min(calculate[i], calculate[i - j * j] + 1);
            }
        }
        return calculate[n];
    }
}

// Time: O(nlogn)  Space: O(n)
/*
    calculate[i] represents the perfect square sum to i
    calculate[i] = the min numbers of squares sum combinations from 1 to j, which j * j <= i

*/
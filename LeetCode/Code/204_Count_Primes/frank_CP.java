class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        int res = 0;
        for (int i = 2; i < n; i ++) {
            if (isPrime[i]) {
                res ++;
            }
            for (int j = 2; j * i < n; j ++) {
                isPrime[i * j] = false;
            }
        }
        return res;
    }
}
// T: O(n^2)  O(n)


// if a number is not prime, it must be the product of two numbers less than it
// So, we can use an Array to store each not prime number
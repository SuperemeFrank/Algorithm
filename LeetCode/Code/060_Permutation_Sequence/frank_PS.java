class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>(); //use List to keep to rest numbers 
        String res = new String();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        int[] fact = new int[n + 1];   //map how many number can n numbers generate
        fact[0] = 1;
        for (int i = 1; i <= n; i ++) {
            fact[i] = i * fact[i - 1];
        }
        k = k - 1;
        for (int i = n - 1; i >= 0; i --) {
            int index = k / fact[i];
            k = k % fact[i];
            res = res + nums.get(index);
            nums.remove(index);        
        }
        return res;
    }
}

/** T: O(n). S; O(n)
    if we list all the permutation and find the kth, time complexity will be large

    if we peak k as the first root, then the follow question would be the permutation of n - 1 rest numbers
    For n numbers we can peak n root, so we need to know which root the kth will belong to

    Here we use List to store the non-permuted numbers, because if we pick one number, we can easily delete it 
    and the list follows the original order 
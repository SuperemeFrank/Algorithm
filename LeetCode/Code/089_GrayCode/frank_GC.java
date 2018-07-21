class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i ++) {   // the largest numbers of result it can generate
            res.add(i ^ i >> 1);        //G(i) = i ^ i/2    i means the ith gray code
        }
        return res;
    }
}
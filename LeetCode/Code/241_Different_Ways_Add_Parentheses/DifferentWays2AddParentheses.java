// assume: the input is always valid
// classical Divide & Conquer Solution
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) { // recursion rule
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') { 
                List<Integer> part1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> part2 = diffWaysToCompute(input.substring(i + 1));
                for (int p1 : part1) {
                    for (int p2 : part2) {
                        switch (ch) {
                            case '+' :
                                ret.add(p1 + p2);
                                break;
                            case '-' :
                                ret.add(p1 - p2);
                                break;
                            case '*' :
                                ret.add(p1 * p2);
                                break;
                        }
                    }
                }
            }
        }
        if (ret.size() == 0) { // base case
            ret.add(Integer.valueOf(input));
        }
        return ret;
    }
}
// Time: O(n ^ 4)   Space: O(n + n ^ 2)

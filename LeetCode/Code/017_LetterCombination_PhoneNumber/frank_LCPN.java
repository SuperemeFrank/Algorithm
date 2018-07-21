class Solution {
    private String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0 || digits == null){
            return res;
        }
        helper(res, digits, "", 0);
        return res;
    }
    public void helper(List<String> res, String digits, String s, int index){
        if (index == digits.length()){
            res.add(s);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for( int i = 0; i < letters.length(); i++){
            helper(res, digits, s + letters.charAt(i), index + 1);
        }
    }
}

//Traceback method (like recursion, but difference in idea)
//1. Mapping each case
//2. set an index as an argument of helper()
//3. return point: index == length
//4. use for loop to iterate each case
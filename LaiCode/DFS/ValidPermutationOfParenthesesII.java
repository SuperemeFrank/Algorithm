public class Solution {
  public List<String> validParentheses(int l, int m, int n) {
    
    int[] parenNum = {l, m, n};
    char[] paren = {'(', '<', '{', ')', '>', '}'};
    List<String> res = new ArrayList<>();
    int length = (l + m + n) * 2;
    dfsHelper(res, parenNum, paren, new LinkedList<Character>(), new StringBuilder(), length);
    return res;
  }
  
  private void dfsHelper(List<String> res, int[] parenNum, char[] paren,
                        Deque<Character> stack, StringBuilder prefix, int length) {
    if (prefix.length() >= length) {
      res.add(prefix.toString());
    }
    for (int i = 0; i < paren.length; i++) {
      if (i < 3 && parenNum[i] > 0) {
        prefix.append(paren[i]);
        parenNum[i] -= 1;
        stack.offerFirst(paren[i]);
        dfsHelper(res, parenNum, paren, stack, prefix, length);
        stack.pollFirst();
        parenNum[i] += 1;
        prefix.deleteCharAt(prefix.length() - 1);
      }else if (i >= 3){
        if (!stack.isEmpty() && 
            (stack.peekFirst() == paren[i - 3])) {
        prefix.append(paren[i]);
        char tmp = stack.pollFirst();
        dfsHelper(res, parenNum, paren, stack, prefix, length);
        stack.offerFirst(tmp);
        prefix.deleteCharAt(prefix.length() - 1);
        }
      }
    }
  }
}

/* Time: O (3 ^ n)  Space: O(n)   n = l + n + m
     l = 2 m = 2 n = 1
                         /  |  |  |  |  \               
position 1              (   <  {  )x >x  }x      
                      /|||\
position 2           ( < { ) ...

...
position 10

to add right paren, it must be matched to previous added paren
to add left paren, the number of it must be limited

*/
class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> deleteSet = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        while (j < s.length() ) {
            char cur = s.charAt(j);
            if (cur == '(') {
                stack.offerFirst(j);
            }
            
            if (cur == ')') {
                if (stack.size() <= 0) {
                    deleteSet.add(j);
                }else {
                    stack.pollFirst();
                }
            }
            j++;
        }
        
        while (!stack.isEmpty()) {
            deleteSet.add(stack.pollFirst());
        }
        
        StringBuilder res = new StringBuilder();
        for (int x = 0; x < s.length(); x++) {
            if (deleteSet.contains(x)) continue;
            res.append(s.charAt(x));
        }
        
        return res.toString();
    }
}

/*
    Time: O(n) n is the length of the String
    Space: O(n) n is the length of the String
    
    Stack to store the pos of '(' that haven't been matched.
    j represents the substring subString which is from [0, j],
    if current subString's ')' are more than '(', it cannot form a valid parenthese string absolutely, 
    then we must delete ')'.
    
    the '(' left in the stack are not been matched, we must remove them.
    

*/
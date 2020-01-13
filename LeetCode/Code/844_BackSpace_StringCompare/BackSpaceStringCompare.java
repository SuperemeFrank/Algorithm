class Solution {
    public boolean backspaceCompare(String S, String T) {
        Deque<Character> stackS = new LinkedList<>();
        Deque<Character> stackT = new LinkedList<>();
        
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                stackS.pollFirst();
            }else {
                stackS.offerFirst(S.charAt(i));
            } 
        }
        
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                stackT.pollFirst();
            }else {
                stackT.offerFirst(T.charAt(i));
            } 
        }
        
        while (!stackS.isEmpty() && !stackT.isEmpty()) {
            if (stackS.pollFirst() != stackT.pollFirst()) {
                return false;
            }
        }
        
        return stackS.isEmpty() && stackT.isEmpty();
    }
}

/*  Time: O(n + m)  Space: O(n + m)
    Use two stack to reconstruct both Strings, then compare
*/
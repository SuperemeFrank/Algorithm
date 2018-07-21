class Solution2 {
    public boolean verifyPreorder(int[] preorder) {
    int low = Integer.MIN_VALUE, i = -1;
    for (int p : preorder) {
        if (p < low)
            return false;
        while (i >= 0 && p > preorder[i])
            low = preorder[i--];
        preorder[++i] = p;
    }
    return true;
    }
}
// Time: O(n)    Space: O(1)

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null) {
            return false;
        }
        Deque<Integer> stack = new LinkedList<>();
        int low = Integer.MIN_VALUE;
        for (int curr : preorder) {
            if (curr < low) {
                return false;
            }
            while (!stack.isEmpty() && curr > stack.peekFirst()) {
                low = stack.pollFirst();
            }
            stack.offerFirst(curr);
        }
        return true;
    }
}
// Time: O(n)  Space: O(n)

//  max and min to limit the nextNumber
/*
    when next > previous, it must be a right child of a leaf node, 
    so every node in the rest should larger than that leaf node

*/



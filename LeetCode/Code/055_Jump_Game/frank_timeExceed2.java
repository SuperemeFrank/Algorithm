class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int[] visited = new int[nums.length];
        Stack<newType> stack = new Stack<>();
        newType firstPos = new newType(0, nums[0]);
        stack.push(firstPos);
        visited[0] = 1;
        while(!stack.isEmpty()) {
            newType pos = stack.pop();
            int start = pos.index;
            int nextPos = start + pos.value;
            if (nextPos >= nums.length - 1) {
                return true;
            }
            if (pos.value == 0) {
                continue;
            }
            for (int i = start + 1; i <= nextPos; i++) {
                if (nums[i] + i <= nextPos) {
                    continue;
                }
                if (visited[i] == 0){
                stack.push(new newType(i, nums[i]));
                visited[i] = 1;
                }
            }
        }
        return false;
    }
}

class newType {
    public int index;
    public int value;
    public newType(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

//DFS non-recursion
//out of time
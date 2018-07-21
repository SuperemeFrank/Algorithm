class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxPos) {
                return false;
            }
            maxPos = Math.max(i + nums[i], maxPos);
        }
        return true;
    }
}

//O(n) clear



class Solution2 {
    public boolean canJump(int[] nums) {
        // TODO: corner case
        if (nums == null || nums.length <= 1) {
            return true;
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 0; j < list.size(); j++) {
                int zero = list.get(j);
                if (zero - i < nums[i]) {
                    list.remove(j);
                    j--;
                }
            }
            if (nums[i] == 0) {
                list.add(i);
            }            
        }
        if (list.size() > 0) {
            return false;
        }
        return true;
    }
}


// idea the key whether can get to end is the 0
// Time: O(N * k)  Space:O(k)   K is the number of 0
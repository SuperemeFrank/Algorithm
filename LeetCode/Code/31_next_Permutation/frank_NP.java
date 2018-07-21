class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1 || nums == null) {
            return;
        }
        int right = nums.length - 2;
        while(right > 0 && nums[right] >= nums[right + 1]) {
            right --;
        }
        if (right == 0 && nums[right] >= nums[right + 1]) {
            for (int i = 0; i < nums.length/2; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = temp;
            }
            return;
        }
        int left = right;
        int minLeft = left + 1;
        while (left < nums.length) {
            if (nums[left] > nums[right] && nums[left] <= nums[minLeft]) {
                minLeft = left;
            }
            left ++;
        }
        
        int temp = nums[right];
        nums[right] = nums[minLeft];
        nums[minLeft] = temp;
        for (int i = right + 1; i <= (nums.length - 1 + right)/2; i++) {
                int temp2 = nums[i];
                nums[i] = nums[nums.length - i + right ];
                nums[nums.length - i + right] = temp2;
            }
        
    }
}

//1.from back to begin find the first index that nums[i] < nums[i + 1], mark as right
//2.from "right" to end find the smallest value that greater than nums[right]
//3.Exchange them
//4.Reverse the subArray after nums[right]
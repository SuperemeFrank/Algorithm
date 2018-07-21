class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {     // get the first index disturb descending order
            i--;    
        }
        if (i >= 0) {   // if the index exist
            int j = nums.length - 1;     
            while (j > i && nums[j] <= nums[i]) {   // find the rightmost larger id
                j--;
            }
            swap(nums, i, j);
            reverse(nums, i + 1, nums.length - 1);  // reverse the subarray and get the next permutation
        } else {    // if the array is descending
            reverse(nums, 0, nums.length - 1);
        }
        
    }
    
    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
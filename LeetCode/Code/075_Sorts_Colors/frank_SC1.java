class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int index = left;
        while (index <= right){
            if (nums[index] == 0) {
                swap(nums, index ++, left ++);  //index is faster than left, so when nums[i] = 0, nums[left] must be 1
                                                //the number before left is 0, between index and left is 1, after index is unknown
            }else if (nums[index] == 1) {
                index ++;
            }else {
                swap(nums, index, right --);    //after swap the index should stay, because nums[index] can be 0
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/** the numbers before left are 0, after right are 2, beteewn left and right are 1
    use index to iterate, when it reachs right it should stop.
      
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
    for (int n : nums)
        if (i < 2 || n > nums[i-2])
            nums[i++] = n;
    return i;
    }
}

//I don't know the what this problem ask me to do 
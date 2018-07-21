class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        quickSort(nums, 0, nums.length - 1);
        StringBuilder res = new StringBuilder();
        for (int i : nums) {
            res.append(i);
        }
        
        while (res.length() > 1 && res.charAt(0) == '0') { // delete {'0', '0'} case
            res.deleteCharAt(0);
        }
        }
        return res.toString();
    }
    public void quickSort(int[] nums, int start, int end) { // use quickSort to sort the nums
        if (start >= end) {
            return;
        }
        int pi = partition(nums, start, end);
        
        quickSort(nums, start, pi - 1);
        quickSort(nums, pi + 1, end);
    }
    
    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1;
        for (int j = start; j <= end; j ++) {
            if (prior(nums[j], pivot)) {
                i ++;
                swap(nums, j, i);
            }
        }
        return i;
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public boolean prior(int num1, int num2) { // if num1 prior to num2 return true
        String str1 = num1 + "";
        String str2 = num2 + "";
        String s1 = str1 + str2;
        String s2 = str2 + str1;
        if (s1.compareTo(s2) >= 0) {
            return true;
        }
        return false;
    }
}

// quickSort      learn to use priorityQueue
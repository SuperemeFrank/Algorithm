class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int index = m + n - 1;
        while (index >= 0) {
            int greaterNum = 0;
            if (p1 >= 0 && p2 >= 0) {
                if(nums1[p1] > nums2[p2]) {
                    greaterNum = nums1[p1--];
                } else {
                    greaterNum = nums2[p2--];
                }
            } else if (p1 >= 0) {
                greaterNum = nums1[p1--];
            } else {
                greaterNum = nums2[p2--];
            }
            nums1[index--] = greaterNum;
        }
    }
}


/*
	Time: O(n)  Space: O(1)
	insert the largest number from end to beginning
*/
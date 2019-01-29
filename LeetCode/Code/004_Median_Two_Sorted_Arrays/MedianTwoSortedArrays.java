class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int num1 = (nums1.length + nums2.length + 1) / 2;
        int num2 = (nums1.length + nums2.length + 2) / 2;
        if ((nums1.length + nums2.length) % 2 == 1) {
            return findMedian(nums1, 0, nums2, 0, num1);
        }else {
            return (findMedian(nums1, 0, nums2, 0, num1) + findMedian(nums1, 0, nums2, 0, num2)) / 2;
        }
    }
    
    
    private double findMedian(int[] nums1, int l1, int[] nums2, int l2, int k) {
        int mid1 = l1 + k/2 - 1;
        int mid2 = l2 + k/2 - 1;
        if (k == 1) {
            if (l1 < nums1.length && l2 < nums2.length) {
                return (double)Math.min(nums1[l1], nums2[l2]);
            }else {
                return l1 < nums1.length ? nums1[l1] : nums2[l2];
            }
        }
        
        if (mid1 >= nums1.length) {
            return findMedian(nums1, l1, nums2, mid2 + 1, k - k/2);
        }
        
        if (mid2 >= nums2.length) {
            return findMedian(nums1, mid1 + 1, nums2, l2, k - k/2);
        }
        
        if (nums1[mid1] < nums2[mid2]) {
            return findMedian(nums1, mid1 + 1, nums2, l2, k - k/2);
        }else {
            return findMedian(nums1, l1, nums2, mid2 + 1, k - k/2);
        }
    }
}



/*  Time: O(log(n + m))  Space: O(log(m + n))
    this problem can be transfered to find the kth smallest elements in tow arrays
    the median = ((n + m + 1)/2 + (n + m + 2)/2) /2
    
    1 2 3 4 5    3 4 5 6
    
    to find the kth elements in two arrays, we use binary search
    
    for each time, we get k/2 th elements both in nums1 and nums2,
    if nums1[k/2] < nums2[k/2], we can cut the current k/2 th elements in nums1
    
    nums1: l1 
    nums2: l2 
    k
    
    Case1: l1 + k/2 < nums1.length && l2 + k/2 < nums2.length 
        case 1.1: nums1[l1 + k/2] <= nums2[l2 + k/2]
            l1 = l1 + k/2 + 1
        case 1.2: nums1[l1 + k/2] > nums2[l2 + k/2]
            l2 = l2 + k/2 + 1
    Case2: l1 + k/2 >= nums1.length || l2 + k/2 >= nums2.length
        case 2.1 l1 + k/2 >= nums1.length
            l2 = l2 + k/2 + 1
        case 2.2 l2 + k/2 >= nums2.length
            l1 = l1 + k/2 + 1
    Case3: k = 1
        return min(l1, l2)

*/
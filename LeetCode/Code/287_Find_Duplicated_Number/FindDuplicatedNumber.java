class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int slow = 0;
        int fast = 0;
        while (nums[fast] != nums[slow] || fast == 0) {
            fast = nums[fast];
            fast = nums[fast];
            slow = nums[slow];
        }
        
        fast = 0;
        while (nums[fast] != nums[slow]) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return nums[fast];
    }
}

/*  Time: O(n)  Space: O(1)
    The same idea as Linked List Cycle II
    
    assume that the array is a linked list where the value is the 'next' pointer. index is how we can visit the next node
    because there are duplicate which means one node has been pointed by multiple nodes.
    There must be an cycle in the linked list,
    so we can use the same idea as Linked List Cycle II
*/
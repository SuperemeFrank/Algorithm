class Solution {
    public void wiggleSort(int[] nums) {
        
        for (int i = 0; i < nums.length; i = i + 2) {
            int maxIndex = i;
            if (i + 1 < nums.length) {
                maxIndex = nums[i + 1] > nums[maxIndex] ? i + 1 : maxIndex;
            }
            if (i + 2 < nums.length) {
                maxIndex = nums[i + 2] > nums[maxIndex] ? i + 2 : maxIndex;
            }
            if (i + 1 < nums.length) {
                swap(nums, i + 1, maxIndex);
            }
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    
}


/* Time: O(n)   Space: O(1)
    3 5 2 1 6 4
    
    for each 3 pairs, we need to find the max number in them, and swap it with their peak position.
    for exaple: 
        the first pair: 3 5 2,   max 5
        the second pair: 2 1 6,  max 6, swap 6 with 1
        ...
    there are overlap numbers between each neighbouring pair, 
    it's easy to prove:
     if the current pair   [small1 large small2]  
     if small2 swap with another element, based on out rule, the element must no larger than small2
     
Solution2: get the top n/2 elements, and put them to the peak positions
*/
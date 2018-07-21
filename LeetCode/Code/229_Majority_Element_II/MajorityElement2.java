class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int number1 = 0;
        int number2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number1) {
                count1++;
            }else if (nums[i] == number2) {
                count2++;
            }else if (count1 == 0) {
                number1 = nums[i];
                count1++;
            }else if (count2 == 0) {
                number2 = nums[i];
                count2++;
            }else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number1) {
                count1++;
            }else if (nums[i] == number2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            res.add(number1);
        }
        if (count2 > nums.length / 3) {
            res.add(number2);
        }
        return res;
    }
}

/*
    idea: the majority numbers are at most two, so we find the top twp frequent numbers, and then count 
        their number.
*/
// Time: O(n)  Space: O(1)

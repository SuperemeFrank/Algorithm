class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3) return 0;
        int res = nums[0] + nums[1] +nums[2];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int low = i + 1, high = nums.length - 1;
            int sum = target - nums[i];
            while(low < high){
                if(sum == nums[low] + nums[high]) return target;
                else if(sum > nums[low] + nums[high]){
                    res = Math.abs(target - res) > Math.abs(sum - nums[low] - nums[high]) ? nums[low] + nums[i] + nums[high] : res;
                    low++;
                }else{
                    res = Math.abs(target - res) > Math.abs(sum - nums[low] - nums[high]) ? nums[low] + nums[i] + nums[high] : res;
                    high--;
                }
            }
        }
        return res;
    }
}

//the same idea of 3sum
//1. sort first
//2. nums[i] as the smallest one, and search the closest by moving points low and high
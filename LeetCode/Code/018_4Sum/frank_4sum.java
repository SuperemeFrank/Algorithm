class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; j++){ 
                if(j > i + 1 && nums[j] == nums[j - 1]) continue; //*** j > i + 1, if not [0,0,0,0] 0 will returen []
                int low = j + 1, high = nums.length - 1;
                int sum = target - nums[i] - nums[j];
                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while(low < nums.length - 1 && nums[low] == nums[low + 1]) low++;
                        while(high > 0 && nums[high] == nums[high - 1])high--;
                        low++;
                        high--;
                    }else if(nums[low] + nums[high] > sum){
                        high--;
                    }else low++;

                }
            }
        }
        return res;
    }
        
}

//The same idea as 3 sum
class Solution {
    public void wiggleSort(int[] nums) {
        int[] count = new int[10000];
        for(int i = 0; i < nums.length; i++){
            count[nums[i] + 5000]++;
        }
        int index = 0;
        for(int i = 0; i < 10000; i++){
            while(count[i] > 0){
                nums[index] = i - 5000;
                count[i]--;
                index++;
            }    
        }
    // Counting Sort, O(n) + O(1)
        int temp[] = new int[nums.length];
        int mid = (nums.length - 1)/2;
        int highEven = (nums.length - 1) % 2 == 0 ? nums.length - 1 : nums.length - 2;  
        int lowOdd = 1;
        for(int i = 0; i <= mid; i++){
            temp[highEven] = nums[i];
            highEven = highEven - 2;
        }
        for(int j = nums.length - 1; j > mid; j--){
            temp[lowOdd] = nums[j];
            lowOdd = lowOdd + 2;
        }
        System.arraycopy(temp,0,nums,0,nums.length);
        }
    }
    //This is the principle, just keep in mind

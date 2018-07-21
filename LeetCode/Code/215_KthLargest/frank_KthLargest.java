class Solution {
    public int findKthLargest1(int[] nums, int k) { //Quick-Select
        int left = 0, right = nums.length - 1;
        while(true){
        int pos = partition(nums, left, right);
            if(pos == k - 1){
            return nums[pos];
        }else if (pos > k - 1){
            right = pos - 1;
        }else{  
            left = pos + 1;
            }
        }
        
    }
    public int findKthLargest(int[] nums, int k) {//Priority Queue
        PriorityQueue<Integer> map = new PriorityQueue<>();
        for (int num : nums){
            map.add(num);
            if(map.size() > k){
                map.poll();
            }
        }
        return map.poll();
        
    }
    public int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int l = left + 1, r = right;
        while(l <= r){
            if(nums[l] < pivot && nums[r] > pivot){
                swap(nums, l++ , r--);
            }
            if(nums[l] >= pivot) l++;
            if(nums[r] <= pivot) r--;
        
    }
        swap(nums, left, r);
        return r;
    }
    public void swap(int[] nums, int l, int r){
        int temp = 0;
        temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
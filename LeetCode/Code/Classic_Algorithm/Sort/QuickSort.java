public class quickSort{
	public static void main(String[] args) {
		int[] nums = {1,3,4,2,3,6,4,2,1,2,3};
		quickSort qs = new quickSort();
		qs.quicksort(nums, 0, nums.length - 1);
		for (int i : nums) {
			System.out.println(i);
		}
	}
	public void quicksort (int[] nums, int low, int high) {
		if (low < high) {
			int pi = partition(nums, low, high);
			quicksort(nums, low, pi - 1);
			quicksort(nums, pi + 1, high);
		}
	}

	public int partition (int[] nums, int low, int high) {
		int pivot = nums[high];
		int i = low; 
		for (int j = low; j <= high; j++) {
			if (nums[j] <= pivot) {
				
				swap(nums, i, j);
				i ++;
			}
		}
		return --i;
	}

	public int partition2(int[] array, int left, int right) {
  	int p = array[right];
        int rightBound = right - 1;
        while (left <= rightBound) {  // if < the element at left == right could be miss sorted
            if (array[left] < p) {
                left++;
            } else {
                swap(array, left, rightBound);
                rightBound--;
            }
        }
        swap(array, left, right); // we swap x with right, so we must make sure x is no smaller than right
        return left;
  }

	public void swap(int[] nums, int indexA, int indexB) {
		int tmp = nums[indexA];
		nums[indexA] = nums[indexB];
		nums[indexB] = tmp;
	}

}


/*
	give an array, get the sum of all the subarray it can generate

	example: [1, 2, 3]
	SubArray: [1] [2] [3] [1, 2] [2, 3] [1, 2, 3]

	hint: the length of the array could be large
*/
import java.util.*;

class Solution {
	public long subArraySum(List<Integer> nums) {
		if (nums == null) {
			return 0;
		}
		long res = 0;
		for (int i = 0; i < nums.size(); i++) {
			long cur = 0;
			for (int l = i; l < nums.size(); l++) {
				cur += nums.get(l);
				res += cur;
			}
		}
		return res;
	}
}

/* Time: O(n ^ 2)  Space: O(1)
	for each index i as the start point of subArrays, it can generate length - i subArray with length from 1 to length - i

	exp: [1, 2, 3]
	for 1, it can generate [1] [1, 2] [1, 2, 3]
	for 2, it can generate [2], [2, 3]

	for each start points, the sum of length of l subarray equals to l - 1 + nums[l],
	so we can get the sum of subarrays of a certain start points in one traverse
*/

public class LinkedInSubArraySum {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		Solution so = new Solution();
		System.out.println(so.subArraySum(list));
	}
}
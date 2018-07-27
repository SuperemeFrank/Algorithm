import java.util.*;
/*
	Problem: print all combinations of coins that sum up to a total value k.
	e.g Total value: 99     coin value: 25, 10, 5, 1
	
	                                                     root(99)
	                                               /     |         |       \
	coins 0 (25 cent):                       0x25(99)   1x25(74)  2x25(49)  ...                   
                                            / ||||\       ...       ...
    coins 1 (10 cent):                   0x10 ...         ...       ...
           ...

    level: 4
    Time = O(99^4)

    1.每一层代表什么意义？ 一般来讲解题之前就知道DFS要recurse多少次
		每层代表用多少这种面额的coins
	2.每层有多少个状态/case 需要try？
		状态数 = total / coins + 1
*/

class Solution {
	public List<List<Integer>> coinsCombine(int[] coins, int target) {
		List<List<Integer>> res = new ArrayList<>();
		// corner case
		if (coins == null) {
			return res;
		}
		dfsHelper(target, 0, coins, new ArrayList<Integer>(), res);
		return res;
	} 

	public void dfsHelper(int target, int coin, int[] coins, List<Integer> combine, List<List<Integer>> res) {
		if (coin == coins.length - 1) {
			if (target % coins[coin] == 0) {
				combine.add(target / coins[coin]);
				res.add(combine);
				combine.remove(combine.size() - 1);	
			}
			return;
		}
		int maxNum = target / conis[coin];
		for (int i = 0; i <= maxNum; i++) {
			combine.add(i);
			dfsHelper(target - i * coins[coin], coin + 1, coins, combine, res);
			combine.remove(combine.size() - 1);
		}
	}
}

// Time O(N ^ K)  k is the types of coins, n is the target		Space: O(K)
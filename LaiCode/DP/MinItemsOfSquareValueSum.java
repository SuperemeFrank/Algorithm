class Solution {
	public int cut(int num) {
		if (num < 0) {
			return 0;
		}
		if (num == 0) {
			return 1;
		}
		int[] M = new int[num + 1];
		M[0] = 0;
		for (int i = 1; i <= num; i++) {
			int tmp = (int)Math.sqrt(i);
			int min = tmp + M[i - tmp * tmp];
			for (int j = 1; j < i; j++) {
				min = Math.min(min, M[j] + M[i - j]);
			}
			M[i] = min;
		}
		return M[num];
	}
}

/*	Time: O(num^2)  Space: O(num)
	M[i] represents the min number of items plus to i
	for j from 1 to i - 1, M[i] = min { M[j] + M[i - j]}
*/


class Solution2 {
	public int cut(int num) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		int[] M = new int[num + 1];
		M[0] = 0;
		for (int i = 1; i <= num; i++) {
			M[i] = i;
			for (int j = 1; j <= (int)(Math.sqrt(i)); j++) {
				M[i] = Math.min(M[i], M[i - j * j] + 1);
			}
		}
		return M[num];
	}
}
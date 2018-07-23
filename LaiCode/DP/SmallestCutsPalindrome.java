public class SmallestCutsPalindrome {
	public static void main(String[] args) {
		String ad = "aaas";
		int a = Solution2.minCuts(ad);
		System.out.println(a);
	}
}



class Solution1 {
	public static int minCuts(String input) {
		if (input == null || input.length() == 0) {
			return 0;
		}
		int[] M = new int[input.length()];
		char[] array = input.toCharArray();
		M[0] = 0;
		for (int i = 1; i < array.length; i++) {
			M[i] = i;
			for (int j = 0; j < i; j++) {
				if (isPal(array, 0, i)) {
					M[i] = 0;
					break;
				}else if (isPal(array, j + 1, i)) {
					M[i] = Math.min(M[i], M[j] + 1);
				}
			}
		}
		return M[array.length - 1];
	}

	private static boolean isPal(char[] array, int start, int end) {
		while (start < end) {
			if (array[start++] != array[end--]) {
				return false;
			}
		}
		return true;
	}
}
// Time: O(n ^ 3)  Space: O(n)
/*
	M[i] represents the smallest cuts from array[0] - array[i], including i
	j represents the current cut at the right side of jth element
*/

class Solution2 {
	public static int minCuts(String input) {
		if (input == null) {
			return 0;
		}
		int[] M = new int[input.length()];
		M[0] = 0;
		boolean[][] isPal = allPal(input);
		for (int i = 1; i < input.length(); i++) {
			M[i] = i;
			for (int j = 0; j < i; j++) {
				if (isPal[0][i]) {
					M[i] = 0;
					break;
				}else if (isPal[j + 1][i]) {
					M[i] = Math.min(M[i], M[j] + 1);
				}
			}
		}
		return M[input.length() - 1];
	}

	private static boolean[][] allPal(String input) { // get all palindrome
		boolean[][] isPal = new boolean[input.length()][input.length()];
		for (int i = 0; i <= 2 * input.length() - 2; i++) {
			int left = i / 2;
			int right = (i + 1) / 2;
			isPal[left][right] = input.charAt(left) == input.charAt(right);
			int p = 1;
			while (left - p >= 0 && right + p < input.length()) {
				if (input.charAt(left - p) != input.charAt(right + p)) {
					break;
				}else {
					isPal[left - p][right + p] = true;
					p++;
				}
			}
		}
		return isPal;
	}
}

// Time: O (n^2)  Space: O(n^2)
/*
	to pre-processing, we get 2n center points to expand them as the center
*/

/*
	From: TripleByte

	given two strings, get the minimum distance of deletion to make the two strings the same.

	eg, 'cat' and "at",   the minimum deletion is to delete 'c' which in ASCII is 99, the result is 99.
	eg, 'cat' and "bat",   the minimum deletion is to delete 'c' and 'b' which in ASCII is 99 + 98, the result is 197.
*/
public class ASCIIDeletionDistance {
	public static void main(String[] args) {
		System.out.println(deleteDistance("thought", "sloughs"));
	}

	public static int deleteDistance(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return 0;
		}
		int[] res = new int[1];
		res[0] = Integer.MAX_VALUE;
		helper(str1, 0, str2, 0, 0, res);
		return res[0];		
	}

	private static void helper(String str1, int s1, String str2, int s2, 
								int sum, int[] res) {

		if (s1 == str1.length()) {
			for (int i = s2; i < str2.length(); i++) {
				sum += str2.charAt(i);
			}
			res[0] = Math.min(res[0], sum);
			return;
		}
		if (s2 == str2.length()) {
			for (int i = s1; i < str1.length(); i++) {
				sum += str1.charAt(i);
			}
			res[0] = Math.min(res[0], sum);
			return;
		}

		char ch1 = str1.charAt(s1);
		char ch2 = str2.charAt(s2);
		if (ch1 == ch2) {
			helper(str1, s1 + 1, str2, s2 + 1, sum, res);
		}

		sum += str1.charAt(s1);
		helper(str1, s1 + 1, str2, s2, sum, res);
		sum -= str1.charAt(s1);

		sum += str2.charAt(s2);
		helper(str1, s1, str2, s2 + 1, sum, res);
		sum -= str2.charAt(s2);

		sum += str1.charAt(s1);
		sum += str2.charAt(s2);
		helper(str1, s1 + 1, str2 + 1, s2, sum, res);
		sum -= str1.charAt(s1);
		sum -= str2.charAt(s2);
	}
}

/*
	Time: O(4 ^ (m + n)). Space: O(m + n)
	
	dfs
	0						cat, at
					     /     |      \
	1				   at,at  cat,t  at, t
                      / | \ 
    2              t,at at,t t,t    ...

               ...

	1. three branches in each level
	2. each level represents what to delete, actually there are four cases

	case1: i = j, recurse forward
	case2: i != j
		2.1 delete str1
		2.2 delete str2
		2.3 delete str1 and str2

*/
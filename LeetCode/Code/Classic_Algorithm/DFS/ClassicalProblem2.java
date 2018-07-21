import java.lang.*;
import java.util.*;
/*
	Problem: find all valid permutation using the parenthesis provided ()()()
                                            empty
	                                     /         \
	position 0                         (             ) (invalid)
                                     /    \         /  \
	position 1                     ((     ()      )(   )) (invalid) 
                                 /   \   /   \
	position 2                (((   (() ()(  (()(invalid)

	...

	1.每一层代表什么意义？ 一般来讲解题之前就知道DFS要recurse多少次
		每层代表一个position
	2.每层有多少个状态/case 需要try？
		每层两种状态：add '('  or add ')'
*/

class Solution {
	public List<String> parathesisPerm(int n) {
		
		List<String> res = new ArrayList<>();
		findParathesis(n, 0, 0, new StringBuilder(), res);
		return res;
	}

	public void findParathesis(int n, int left, int right, StringBuilder prefix, List<String> res) {
		if (left == n && right == n) {
			res.add(prefix.toString());
			return;
		}

		if (left < n) {
			prefix.append('(');
			findParathesis(n, left + 1, right, prefix, res);
			prefix.removeCharAt(prefix.size() - 1);
		}

		if (right < left) {
			prefix.append(')');
			findParathesis(n, left, right + 1, prefix, res);
			prefix.removeCharAt(prefix.size() - 1);	
		}
	}
}


// Time: O(2^(2n))   Space: O(2n)
import java.lang.*;
import java.util.*;

/*
	Problem: print all subsets of a set S = {'a', 'b', 'c'}

	empty                   ""
                        /       \
	for a              a          ""
                     /    \     /    \
	for b          ab      a    b    ""
                  /   \   / \    ...
	for c       abc   ab ac  a   ...

	1.每一层代表什么意义？ 一般来讲解题之前就知道DFS要recurse多少次
		每层代表是否添加一个字符
	2.每层有多少个状态/case 需要try？
		每层两种状态：add or not
 */

class Solution{
	public List<String> subset(char[] input) {
		List<String> res = new ArrayList<>();
		if (input == null) {
			return res;
		}
		findSubsets(input, 0, new StringBuilder(), res);
		return res;
	}

	public void findSubsets(char[] input, int index, StringBuilder prefix, List<String> res) {
		if (index >= input.length) {
			res.add(prefix.toString());
			return;
		}
		prefix.append(input[index]);
		findSubsets(input, index + 1, prefix, res); // add char
		prefix.removeCharAt(prefix.size() - 1); // back-stracking
		findSubsets(input, index + 1, prefix, res); // not add char
	}
}

// Time: O(2^n)    Space:O(n)
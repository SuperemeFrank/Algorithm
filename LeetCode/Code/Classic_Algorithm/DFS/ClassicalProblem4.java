import java.util.*;
/*
	Problem: Given a string with no duplicated letters, how to print out all permutations of the string
			                                                  root (a b c)
	                                                     /         |         \
	position 0                                        a (bc)      b(ac)      c(ab)
                                                  /       \       /    \     /    \
	position 1                                 b(c)      c(b)   a(c)   c(a) b(a)  a(b)
                                             /         ...
	position 2                            abc      
	
	1.每一层代表什么意义？ 一般来讲解题之前就知道DFS要recurse多少次
		每层代表一个position
	2.每层有多少个状态/case 需要try？
		每层有状态由剩余个数决定
*/

class Solution {
	public List<String> permutation(char[] input) {
		List<String> res = new ArrayList<>();
		// corner case

		dfsHelper(input, 0, res);
		return res;
	}

	public void dfsHelper(char[] input, int pos, List<String> res) {
		if (pos == input.length) {
			res.add(input.toString());
			return;
		}
		for (int i = pos; i < input.length; i++) {
			swap(input, pos, i);
			dfsHelper(input, pos + 1, res);
			swap(input, pos, i); // back tracking
		}
	}

	public void swap(char[] input, int a, int b) {
		char tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}
}

// Time: O(n!)   Space: O(n)
// SWAP操作很精髓，可以节省Set空间，是一种in-place的操作

//When to use SWAP:
//Conclusion: whenever every single permutation contains all elements in the initial input, then you should consider SWAP.


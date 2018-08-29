class Solution {
	public List<String> insertSpace(String str) {
		if (str == null) {
			return new ArrayList<>();
		}
		List<String> res = new ArrayList<>();
		insert(res, str, new StringBuilder(), 0);
		return res;
	}

	private void insert(List<String> res, String str, StringBuilder prefix, int index) {
		if (index == str.length() - 1) {
			prefix.append(str.charAt(index));
			res.add(prefix.toString());
			prefix.deleteCharAt(prefix.length() - 1);
			return;
		}

		prefix.append(str.charAt(index));
		prefix.append(" ");
		insert(res, str, prefix, index + 1);
		prefix.deleteCharAt(prefix.length() - 1);

		insert(res, str, prefix, index + 1);
		prefix.deleteCharAt(prefix.length() - 1);

	}
}

// n levels, n is the length of str
// each level have two branches, add space or not
// Time: O(2^n)   Space: O(n)
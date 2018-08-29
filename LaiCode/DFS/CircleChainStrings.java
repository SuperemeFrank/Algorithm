class Solution {
	public boolean isChainable(String[] array) {
		if (array == null || array.length == 0) {
			return false;
		}
		if (array.length == 1) {
			return array[0].charAt(0) == array[0].charAt(array[0].length() - 1);
		}

		for (String str : array) {
			if (str == null || str.length() == 0) {
				return false;
			}
		}
		return help(array, 0);
	}

	private boolean help(Stringp[] array, int index) {
		if (index == array.length) {
			return array[index - 1].charAt(array[index - 1].length() - 1) == array[0].charAt(0);
		}

		for (int i = index; i < array.length; i++) {
			if (index == 0 || cancon(array[index - 1], array[i])) {
				swap(array, index, i);
				help(array, index + 1);
				swap(array, index, i);
			}
		}
		return false;
	}

	private void swap(String[] array, int a, int b) {
		String tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	private boolean cancon(String prev, String cur) {
		return prev.charAt(prev.length() - 1) == cur.charAt(0);
	}
}
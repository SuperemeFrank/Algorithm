
public class Find3singleNumber {

	public static  int[] find3(int[] array) {

		int xor = 0;
		for (int num : array) {
			xor ^= num;
		}
		int k = 0;
		while (((xor >> k) & 1) != 0) {
			k++;
		}
		int firstNum = 0;
		for (int num : array) {
			if (((num >> k) & 1) != 0) {
				firstNum ^= num;
			}
		}

		int[] last2 = find2(array, firstNum);

		int[] res = new int[3];
		res[0] = firstNum;
		res[1] = last2[0];
		res[2] = last2[1];

		return res;
	}

	private static  int[] find2(int[] array, int oneNum) {

		int xor = 0;
		for (int num : array) {
			if (num != oneNum) {
				xor ^= num;
			}
		}

		int k = 0;
		while (((xor >> k) & 1) == 0) {
			k++;
		}
		int[] res = new int[2];
		for (int num : array) {
			if (num != oneNum) {
				if (((num >> k) & 1) == 0) {
					res[0] ^= num;
				}else {
					res[1] ^= num;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = {2,2,3,3,4,4,6,5,7,8,8};
		int[] res = find2(a, 7);
		for (int s : res) {
			System.out.println(s);
		}
	}


}
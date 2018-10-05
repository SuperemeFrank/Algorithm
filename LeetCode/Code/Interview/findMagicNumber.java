public class findMagicNumber {
	public static  boolean isMagic(int N, int B) {

		boolean[] digits = new boolean[10];
		int base = B;
		while (B < N) {
			B *= B;
		}

		while (N > 0) {
			if (N >= B) {
				if (digits[N/B]) {
					return false;
				}
				digits[N/B] = true;
				N %= B;
			}

			B /= base;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isMagic(21, 4));		
	}
}
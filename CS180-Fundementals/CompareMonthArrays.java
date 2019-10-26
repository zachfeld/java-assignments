
public class CompareMonthArrays {

	public static void main(String[] args) {
		int[] monthOne = { 12, 3, 4, 5 };
		int[] monthTwo = { 12, 3, 4, 5 };

		compareArray(monthOne, monthTwo);
	}

	public static boolean compareArray(int[] a, int[] b) {

		if (a.length != b.length) {
			System.out.println("These two months are not the same.");
			return false;
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				System.out.println("These months are not the same");
				return false;
			}
		}
		System.out.println("These months are the same");
		return true;
	}
}
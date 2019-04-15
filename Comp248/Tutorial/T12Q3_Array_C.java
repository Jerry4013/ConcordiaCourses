
public class T12Q3_Array_C {

	T12Q3_Array_C() {
		int[] a = create(2047461578);
		System.out.println(evs(a));
	}
	private int evs(int[] a) {
		int n = 0;
		for (int i=0; i<a.length; i++)
			if (a[i] % 2 == 0)
				++n;
		return n;
	}
	private int[] create(long n) {
		long nn = n;
		int cnt = 0;
		while (nn > 0) {
			nn /= 10;
			++cnt;
		}
		int[] a = new int[cnt];
		for (int i=0; n>0; i++) {
			a[i] = (int) (n % 10);
			n /= 10;
		}
		return a;
	}
	public static void main(String[] args) {
		new T12Q3_Array_C();
	}

}

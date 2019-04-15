
public class T12Q3_Array_F {
	T12Q3_Array_F() {
		int[] a = create(6);
		arrange(a);
		arrange(a);
		System.out.println(a[0] + " " + a[1]
				+ " " + a[2]);
	}
	int[] create(int n) {
		int[] a = new int[n];
		for (int i=0; i<a.length; i += 2) {
			a[i] = i + 1;
			a[i+1] = -a[i];
		}
		return a;
	}
	void arrange(int[] a) {
		for (int i=0; i<a.length-1; i++)
			if (a[i] < a[i+1]) {
				int t = a[i];
				a[i] = a[i+1];
				a[i+1] = t;
			}
	}
	public static void main(String[] args) {
		new T12Q3_Array_F();
	}
}

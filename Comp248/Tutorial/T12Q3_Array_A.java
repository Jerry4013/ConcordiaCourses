import java.util.Arrays;
public class T12Q3_Array_A {

	T12Q3_Array_A() {
		char[] a = { 'a', 'b', 'c', 'd', 'e' };
		change(a);
		System.out.println(new String(a));
		System.out.println(Arrays.toString(a));
	}
	private void change(char[] a) {
		for (int i=0; i<a.length/2; i++) {
			char c = a[i];
			a[i] = a[a.length - i - 1];
			a[a.length - i - 1] = c;
		}
	}
	public static void main(String[] args) {
		new T12Q3_Array_A();
	}

}

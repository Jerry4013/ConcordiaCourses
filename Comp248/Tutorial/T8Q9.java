
public class T8Q9 {

	public static void main(String[] args) {
		char[] array1 = {'a', 'c', 'k', 'i', 'b'};
		char[] array2 = {'b', 'i', 'k', 'a', 'c'};
		int size = array1.length;
		boolean[] contain = new boolean[size];
		boolean result = true;
		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				if (array1[i]==array2[j])
					contain[i] = true;
		for (int i=0; i<size; i++)
			if (!contain[i])
				result = false;
		System.out.print(result);
	}
}

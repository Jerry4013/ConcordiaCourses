package textbook.chapter11;

public class BinarySearch {

	public static int search(int[] a, int first, int last, int key) {
		int result = 0;
		if (first > last)
			result = -1;
		else {
			int mid = (first + last) / 2;
			if (key == a[mid])
				result = mid;
			else if (key < a[mid])
				result = search(a, first, mid - 1, key);
			else if (key > a[mid])
				result = search(a, mid + 1, last, key);
		}
		return result;
	}

}

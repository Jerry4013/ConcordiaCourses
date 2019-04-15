package textbook.chapter13.programmingProjects;

public class Q1_ModifiedBinarySearch {
	
	@SuppressWarnings("unchecked")
	public static int search(@SuppressWarnings("rawtypes") Comparable[] a, int first, int last, @SuppressWarnings("rawtypes") Comparable key) {
		int result = 0;
		if (first > last)
			result = -1;
		else {
			int mid = (first + last) / 2;
			if (a[mid].equals(key))
				result = mid;
			else if (a[mid].compareTo(key)>0)
				result = search(a, first, mid - 1, key);
			else if (a[mid].compareTo(key)<0)
				result = search(a, mid + 1, last, key);
		}
		return result;
	}
}

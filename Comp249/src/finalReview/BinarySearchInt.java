package finalReview;

public class BinarySearchInt {
	
	public int search(int[] a, int first, int last, int obj){
		int result = 0;
		if (first > last)
			result = -1;
		else{
			int mid = (first + last)/2;
			if(a[mid]==obj)
				result = mid;
			else if(obj<a[mid])
				result = search(a, first, mid-1, obj);
			else if(obj>a[mid])
				result = search(a, mid+1, last, obj);
		}
		return result;
		
	}
}

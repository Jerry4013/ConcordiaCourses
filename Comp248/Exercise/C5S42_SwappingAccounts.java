
public class C5S42_SwappingAccounts {

	public static void main(String[] args) {
		C5S42_Account a = new C5S42_Account("Ted", 123, 100);
		C5S42_Account b = new C5S42_Account("Mary", 456, 99);
		
		System.out.println(a + " " +b);
		swap(a, b);
		System.out.println(a + " " +b);
	}
	
	public static void swap(C5S42_Account a1, C5S42_Account a2)
	{
		C5S42_Account temp;
		temp = a1;
		a1 = a2; 
		a2 = temp;
	}
}

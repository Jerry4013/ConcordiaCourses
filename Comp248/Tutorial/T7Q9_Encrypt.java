
public class T7Q9_Encrypt {

	public static void main(String[] args) {
		String phrase = "Hello world";
		String newString="";
		for (int i=0; i<phrase.length(); i++)
			newString = newString + (char)(phrase.charAt(i)+1);
		System.out.print(newString);
	}
}

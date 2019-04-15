package tutorial.tutorial9;

public class Q1 {
	public static void main(String[] args) {
		System.out.println(reverse("Hello world"));
	}
	
	public static String reverse(String s){
		if(s.length()==1)
			return s;
		return reverse(s.substring(1)) + s.charAt(0);
	}
}

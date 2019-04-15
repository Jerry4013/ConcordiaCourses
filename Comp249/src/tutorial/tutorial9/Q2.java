package tutorial.tutorial9;

public class Q2 {

	public static void main(String[] args) {
		System.out.println(convertToBinary(6));
	}

	public static String convertToBinary(int x){
		if(x==1 || x==0)
			return String.valueOf(x);
		return convertToBinary(x>>1) + "" + (x&1);
	}
}

package tutorial.tutorial9;

public class Permutation {

	
	public static void main(String[] args) {

	}
	
	public static void print(String prefix, String surffix){
		if(surffix.length()==1)
			System.out.println(prefix + surffix);
		
		for(int i=0; i<surffix.length(); i++)
			print(surffix.charAt(i)+"", "");
	}
	
	
}

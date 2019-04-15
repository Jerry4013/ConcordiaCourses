package tutorial.tutorial11;
import java.util.*;

public class QuestionMark {
	
	public static <T extends Comparable<T>> boolean test(ArrayList<T> a){
		return true;
	}
	
	public static boolean test2(ArrayList<? super Number> a){
		return true;
	}
}

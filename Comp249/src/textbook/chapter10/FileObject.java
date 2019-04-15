package textbook.chapter10;
import java.io.File;
import java.io.IOException;


public class FileObject {

	public static void main(String[] args) {
		File fo = new File("G:\\workspace\\Comp 249\\myfold\\sam.txt");
		try{
			System.out.println(fo.createNewFile());
			
		}catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		System.out.println(fo.length());
	
	}

}

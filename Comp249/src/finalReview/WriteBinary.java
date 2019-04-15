package finalReview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import assignment.a4.Course;
import assignment.a4.CourseList;

public class WriteBinary {
	public static void main(String[] args)  {

		CourseList list1 = new CourseList();
		Course course1 = new Course();
		list1.addToStart(course1);
		
		MyClass m = new MyClass(6584, 'a');
		try{
			ObjectOutputStream binOut = new ObjectOutputStream(new FileOutputStream("data.dat"));
			binOut.writeObject(m);
			binOut.close();
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}catch(IOException e){
			System.out.println("My message");
		}
		
		try{
			ObjectInputStream binIn = new ObjectInputStream(new FileInputStream("data.dat"));
			MyClass n = (MyClass) binIn.readObject();
			System.out.println(n);
			binIn.close();
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}

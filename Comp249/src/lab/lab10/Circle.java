package lab.lab10;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Circle implements Fillable{

	private double x;
	private double y;
	private double radius;
	
	
	public Circle(){ }
	
	/**
	 * @param x
	 * @param y
	 * @param radius
	 */
	public Circle(double x, double y, double radius) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public void draw(int color) {
		PrintWriter fileOut = null;
		try{
			fileOut = new PrintWriter(new FileOutputStream("lab10.txt",true));
		}catch(FileNotFoundException e){
			System.out.println("Cannot create file.");
		}
		fileOut.println("Circle drawn at (" + x + ", " + y + ") with radius " + radius + ", and color " + color);
		fileOut.close();
	}

	@Override
	public void fill(int color) {
		PrintWriter fileOut = null;
		try{
			fileOut = new PrintWriter(new FileOutputStream("lab10.txt",true));
		}catch(FileNotFoundException e){
			System.out.println("Cannot create file.");
		}
	
		fileOut.println("Circle filled at (" + x + ", " + y + ") with radius " + radius + ", and color " + color);
		fileOut.close();
	}

}

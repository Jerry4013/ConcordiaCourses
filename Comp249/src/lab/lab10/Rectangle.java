package lab.lab10;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Rectangle implements Fillable{
	
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public Rectangle(double x1, double y1, double x2, double y2) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	@Override
	public void draw(int color) {
		PrintWriter fileOut = null;
		try{
			fileOut = new PrintWriter(new FileOutputStream("lab10.txt",true));
		}catch(FileNotFoundException e){
			System.out.println("Cannot create file.");
		}
		fileOut.println("Rectangle drawn with upper-left corner at ("+x1+", "+y1+") and lower-right corner at ("+x2+", "+y2+"), and color "+ color);
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
		fileOut.println("Rectangle filled with upper-left corner at ("+x1+", "+y1+") and lower-right corner at ("+x2+", "+y2+"), and color "+ color);
		fileOut.close();
	}
	
	

}

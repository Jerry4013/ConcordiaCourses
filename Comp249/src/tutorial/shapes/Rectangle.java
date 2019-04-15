package tutorial.shapes;

public class Rectangle extends Shape{
	private double width;
	private double height;
	
	public void setWidth(double w){
		width = w;
	}
	
	public void setHeight(double h){
		height = h;
	}
	
	public String toString(){
		return "Rectangle: " + getArea();
	}
	public double getArea(){
		return width * height;
	}
}

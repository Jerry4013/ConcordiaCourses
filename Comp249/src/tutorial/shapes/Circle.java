package tutorial.shapes;

public class Circle extends Shape{
	public double radius;
	
	public void setRadius(double r){
		radius = r;
	}
	public String toString(){
		return "Circle: " + getArea() ;
	}
	
	public double getArea(){
		return Math.PI * radius * radius;
	}
}

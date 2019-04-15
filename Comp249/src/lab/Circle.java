package lab;

public class Circle {
	private double radius;

	public Circle(){
		radius = 0;
	}

	public Circle(double r){
		if(r<=0)
		{
			System.out.println("Radius cannot be less than or equal to 0.");
			System.exit(0);
		}
		radius = r;
	}

	public Circle (Circle anotherCircle){
		if(anotherCircle==null)
		{
			System.out.println("Fail to create a circle.");
			System.exit(0);
		}
		radius = anotherCircle.radius;
	}

	public double getRadius(){
		return radius;
	}
	public void setRadius(double newRadius){
		if(newRadius<=0)
		{
			System.out.println("Radius cannot be less than or equal to 0.");
			System.exit(0);
		}
		radius = newRadius;
	}

	public boolean equals(Object otherObject){
		if(otherObject==null)
			return false;
		if(otherObject.getClass()!=getClass())
			return false;
		Circle anotherCircle = (Circle)otherObject;
		return (radius == anotherCircle.radius );
	}
	
	public double getArea(){
		return radius * radius * Math.PI;
	}
	
	public String toString(){
		return "Radius: " + radius + "\tArea: " + getArea();
	}
	
	public static double getTotalArea(Circle[] circles){
		double TotalArea = 0;
		if(circles==null){
			System.out.println("Fatal error! Nothing in the array");
		}
		for (int i=0; i<circles.length; i++){
			if (circles[i]!=null){
				TotalArea += circles[i].getArea();
			}
		}
		return TotalArea;
	}
	
	
}

package tutorial.shapes;

public class ShapeDriver {

	public static void main(String[] args) {
		Circle c1= new Circle();
		c1.setRadius(2.0);
		System.out.println("Area of c1 "+c1);
		Circle c2= new Circle();
		c2.setRadius(4.0);
		System.out.println("Area of c2 "+c2);
		Rectangle r1= new Rectangle();
		r1.setHeight(2.0);
		r1.setWidth(4.0);
		System.out.println("Area of r1 "+r1);
		Rectangle r2= new Rectangle();
		r2.setHeight(3.0);
		r2.setWidth(6.0);
		System.out.println("Area of r2 "+r2);
		Shape shapes[]={c1,c2,r1,r2};
		// We are using the "totalArea" method here
		System.out.println("Total Area is: "+ totalArea(shapes));
	}
	public static double totalArea(Shape[] s){
		double area = 0;
		for(int i=0; i<4; i++)
		{
			area += s[i].getArea();
		}
		return area;
	}

}

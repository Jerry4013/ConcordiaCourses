package lab;

public class CircleDemo {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		Circle c2 = new Circle(2);
		Circle c3 = new Circle(c2);
		Circle c4 = new Circle(3);
		
		System.out.println("The radius of c1 is: "+c1.getRadius());
		System.out.println("The radius of c2 is: "+c2.getRadius());
		System.out.println("The radius of c3 is: "+c3.getRadius());
		System.out.println("The radius of c4 is: "+c4.getRadius());
		System.out.println();
		
		c3.setRadius(3);
		System.out.println("The new radius of c3 is: "+c3.getRadius());
		System.out.println();
		
		if(c3.equals(c4))
			System.out.println("c3 equals to c4");
		else
			System.out.println("c3 is not equal to c4");
		System.out.println();
		
		System.out.printf("The area of c1 is: %.2f%n", c1.getArea());
		System.out.printf("The area of c2 is: %.2f%n", c2.getArea());
		System.out.printf("The area of c3 is: %.2f%n", c3.getArea());
		System.out.printf("The area of c4 is: %.2f%n", c4.getArea());
		System.out.println();
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println();
		
		Circle[] circles = new Circle[4];
		circles[0] = new Circle(c1);
		circles[1] = new Circle(c2);
		circles[2] = new Circle(c3);
		circles[3] = new Circle(c4);
		
		System.out.printf("The total area of these circles is: %.2f%n", Circle.getTotalArea(circles));
		
	}
}

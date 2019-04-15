package chapter8;

public class Circle extends Shape {
    private double radius;

    @Override
    public double calculateArea() {
        return radius * radius * Math.PI;
    }
}
